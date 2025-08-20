package domain.users;

public class UserClient extends User {
    private String adress;
    private Boolean vip;

    public UserClient(int id, String name, String mailAdress, int phoneNumber, String adress, Boolean vip) {
        super(id, name, mailAdress, phoneNumber);
        this.adress = adress;
        this.vip = vip;
    }

    public String getAdress() {
        return adress;
    }

    public Boolean getVip() {
        return vip;
    }

    public String toString() {
         return "{UserCust:" + super.toString() + ", adress=" + adress + ", vip=" + vip + "}";
    }
}
