package business;

import java.time.LocalDate;

import domain.Date;
import domain.lists.DateNode;
import domain.lists.List;
import domain.lists.UserNode;
import domain.users.User;
import domain.users.UserAssist;
import domain.users.UserClient;
import domain.users.UserVet;

public class UsersController {
    public UsersController() {
    }

    public boolean addUser(User user, List list) {
        if (user == null || list == null) return false;
        list.addUser(user, list);
        return true;
    }

    public boolean removeUser(int id, List list) {
        if (list == null) return false;
        UserNode current = list.getFirstUserNode();
        UserNode previous = null;
        while (current != null) {
            if (current.getUser().getId() == id) {
                if (previous == null) {
                    list.setFirstUserNode(current.getNext());
                } else {
                    previous.setNext(current.getNext());
                }
                if (current.getNext() == null) {
                    list.setLastUserNode(previous);
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public User findUser(int id, List list) {
        if (list == null) return null;
        UserNode current = list.getFirstUserNode();
        while (current != null) {
            if (current.getUser().getId() == id) {
                return current.getUser();
            }
            current = current.getNext();
        }
        return null;
    }

    public String listClients(List list) {
        if (list == null) return "";
        String result = "";
        UserNode current = list.getFirstUserNode();
        while (current != null) {
            if (current.getUser() instanceof UserClient) {//instanceof es un operador que pregunta si el objeto x es del tipo o un subtipo del objeto y
                result += current.getUser().toString() + "\n";
            }
            current = current.getNext();
        }
        return result;
    }

    public String listVets(List list) {
        if (list == null) return "";
        String result = "";
        UserNode current = list.getFirstUserNode();
        while (current != null) {
            if (current.getUser() instanceof UserVet) {
                result += current.getUser().toString() + "\n";
            }
            current = current.getNext();
        }
        return result;
    }

    public String listAssistants(List list) {
        if (list == null) return "";
        String result = "";
        UserNode current = list.getFirstUserNode();
        while (current != null) {
            if (current.getUser() instanceof UserAssist) {
                result += current.getUser().toString() + "\n";
            }
            current = current.getNext();
        }
        return result;
    }

    public UserClient findClient(int id, List list) {
        User user = findUser(id, list);
        if (user instanceof UserClient) {
            return (UserClient) user;
        }
        return null;
    }

    public UserVet findVet(int id, List list) {
        User user = findUser(id, list);
        if (user instanceof UserVet) {
            return (UserVet) user;
        }
        return null;
    }

    public UserAssist findAssistant(int id, List list) {
        User user = findUser(id, list);
        if (user instanceof UserAssist) {
            return (UserAssist) user;
        }
        return null;
    }

    public User[] filterUsersByDay(int day, List list) {
        if (list == null) return null;
        int count = 0;
        UserNode current = list.getFirstUserNode();
        while (current != null) {
            User user = current.getUser();
            if (user instanceof UserVet || user instanceof UserAssist) {
                count++;
            }
            current = current.getNext();
        }
        User[] users = new User[count];
        current = list.getFirstUserNode();
        int index = 0;
        while (current != null) {
            User user = current.getUser();
            if (user instanceof UserVet || user instanceof UserAssist) {
                users[index++] = user;
            }
            current = current.getNext();
        }
        return users;
    }

    public UserClient[] filterClientsWithDatesBetween(LocalDate date1, LocalDate date2, domain.lists.List dateList) {
        if (dateList == null || date1 == null || date2 == null) return null;
        if (date1.isAfter(date2)) return null;

        int count = 0;
        DateNode current = dateList.getFirstDateNode();
        // Primer recorrido: contar clientes con citas en el rango
        while (current != null) {
            Date dateObj = current.getDate();
            if (dateObj.getUser() instanceof UserClient) {
                LocalDate d = dateObj.getDate();
                if ((d.isEqual(date1) || d.isAfter(date1)) && (d.isEqual(date2) || d.isBefore(date2))) {
                    count++;
                }
            }
            current = current.getNext();
        }
        UserClient[] clients = new UserClient[count];
        current = dateList.getFirstDateNode();
        int index = 0;
        // Segundo recorrido: agregar clientes con citas en el rango
        while (current != null) {
            Date dateObj = current.getDate();
            if (dateObj.getUser() instanceof UserClient) {
                LocalDate d = dateObj.getDate();
                if ((d.isEqual(date1) || d.isAfter(date1)) && (d.isEqual(date2) || d.isBefore(date2))) {
                    clients[index++] = (UserClient) dateObj.getUser();
                }
            }
            current = current.getNext();
        }
        return clients;
    }
}