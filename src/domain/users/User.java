package domain.users;

public class User {
    protected int id;
    protected String name;
    protected String mailAdress;
    protected int phoneNumber;

    public User(int id, String name, String mailAdress, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.mailAdress = mailAdress;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return "id=" + id + ", name='" + name + "', mailAdress='" + mailAdress + "', phoneNumber=" + phoneNumber;
    }
    
}


