package domain.users;

public class UserAssist extends User {
    private int activeYears;
    private Boolean active;
    private Boolean[] schedule;

    public UserAssist(int id, String name, String mailAdress, int phoneNumber, int activeYears, Boolean active, Boolean[] schedule) {
        super(id, name, mailAdress, phoneNumber);
        this.activeYears = activeYears;
        this.active = active;
        this.schedule = schedule;
    }

    public int getActiveYears() {
        return activeYears;
    }

    public Boolean getActive() {
        return active;
    }

    public Boolean[] getSchedule() {
        return schedule;
    }

    public String toString() {
        return "{UserAsist:" + super.toString() + " activeYears=" + activeYears + ", active=" + active + ", schedule=" + java.util.Arrays.toString(schedule) + "}";
    }


}
