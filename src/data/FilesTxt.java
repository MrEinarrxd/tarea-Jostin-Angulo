package data;

import domain.lists.List;
import domain.lists.UserNode;
import domain.users.User;
import domain.users.UserClient;
import domain.users.UserVet;
import domain.users.UserAssist;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class FilesTxt {

    public static List loadUsersFromTxt(String filePath) {
        List userList = new List();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split(";");
                String type = parts[0].trim();
                if ("client".equals(type)) {
                    // client;id;name;mail;phone;adress;vip
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String mail = parts[3];
                    int phone = Integer.parseInt(parts[4]);
                    String adress = parts[5];
                    boolean vip = Boolean.parseBoolean(parts[6]);
                    userList.addUser(new UserClient(id, name, mail, phone, adress, vip), userList);
                } else if ("vet".equals(type)) {
                    // vet;id;name;mail;phone;licenseNumb;speciality;salary;activity;schedule
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String mail = parts[3];
                    int phone = Integer.parseInt(parts[4]);
                    int licenseNumb = Integer.parseInt(parts[5]);
                    String speciality = parts[6];
                    double salary = Double.parseDouble(parts[7]);
                    boolean activity = Boolean.parseBoolean(parts[8]);
                    String[] sch = parts[9].split(",");
                    Boolean[] schedule = new Boolean[sch.length];
                    for (int i = 0; i < sch.length; i++) {
                        schedule[i] = Boolean.parseBoolean(sch[i]);
                    }
                    userList.addUser(new UserVet(id, name, mail, phone, licenseNumb, speciality, salary, activity, schedule), userList);
                } else if ("assist".equals(type)) {
                    // assist;id;name;mail;phone;activeYears;active;schedule
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String mail = parts[3];
                    int phone = Integer.parseInt(parts[4]);
                    int activeYears = Integer.parseInt(parts[5]);
                    boolean active = Boolean.parseBoolean(parts[6]);
                    String[] sch = parts[7].split(",");
                    Boolean[] schedule = new Boolean[sch.length];
                    for (int i = 0; i < sch.length; i++) {
                        schedule[i] = Boolean.parseBoolean(sch[i]);
                    }
                    userList.addUser(new UserAssist(id, name, mail, phone, activeYears, active, schedule), userList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void saveUsersToTxt(List userList, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, false))) {
            UserNode current = userList.getFirstUserNode();
            while (current != null) {
                User user = current.getUser();
                if (user instanceof UserClient) {
                    UserClient c = (UserClient) user;
                    pw.printf("client;%d;%s;%s;%d;%s;%b%n",
                            c.getId(), c.getName(), c.getMailAdress(), c.getPhoneNumber(), c.getAdress(), c.getVip());
                } else if (user instanceof UserVet) {
                    UserVet v = (UserVet) user;
                    pw.printf("vet;%d;%s;%s;%d;%d;%s;%.2f;%b;%s%n",
                            v.getId(), v.getName(), v.getMailAdress(), v.getPhoneNumber(),
                            v.getLicenseNumb(), v.getSpeciality(), v.getSalary(), v.getActivity(),
                            Arrays.toString(v.getSchedule()).replaceAll("[\\[\\] ]", ""));
                } else if (user instanceof UserAssist) {
                    UserAssist a = (UserAssist) user;
                    pw.printf("assist;%d;%s;%s;%d;%d;%b;%s%n",
                            a.getId(), a.getName(), a.getMailAdress(), a.getPhoneNumber(),
                            a.getActiveYears(), a.getActive(),
                            Arrays.toString(a.getSchedule()).replaceAll("[\\[\\] ]", ""));
                }
                current = current.getNext();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List loadDatesFromTxt(String filePath, List userList) {
        List dateList = new List();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    LocalDate date = LocalDate.parse(parts[1]);
                    String about = parts[2];
                    int state = Integer.parseInt(parts[3]);
                    LocalDate time = LocalDate.parse(parts[4]);
                    int userId = Integer.parseInt(parts[5]);
                    // Buscar el usuario por id en la lista de usuarios
                    User user = null;
                    UserNode current = userList.getFirstUserNode();
                    while (current != null) {
                        if (current.getUser().getId() == userId) {
                            user = current.getUser();
                            break;
                        }
                        current = current.getNext();
                    }
                    if (user != null) {
                        dateList.addDate(new domain.Date(id, date, about, state, time, user), dateList);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateList;
    }

}