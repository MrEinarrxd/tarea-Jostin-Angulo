package domain.users;

public class UserVet extends User {
    private int licenseNumb;
    private String speciality;
    private double salary;
    private Boolean activity;
    private Boolean[] schedule;

    public UserVet(int id, String name, String mailAdress, int phoneNumber, int licenseNumb, String speciality, double salary, Boolean activity, Boolean[] schedule) {
        super(id, name, mailAdress, phoneNumber);
        this.licenseNumb = licenseNumb;
        this.speciality = speciality;
        this.salary = salary;
        this.activity = activity;
        this.schedule = schedule;
    }

    public int getLicenseNumb() {
        return licenseNumb;
    }

    public String getSpeciality() {
        return speciality;
    }

    public double getSalary() {
        return salary;
    }

    public Boolean getActivity() {
        return activity;
    }

    public Boolean[] getSchedule() {
        return schedule;
    }

   public String toString() {
    return "{UserVet:" + super.toString() + ", licenseNumb=" + licenseNumb + ", speciality='" + speciality + "', salary=" + salary + ", activity=" + activity + ", schedule=" + java.util.Arrays.toString(schedule) + "} ";
   }
}


