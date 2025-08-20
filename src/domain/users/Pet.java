package domain.users;

import java.time.LocalDate;

public class Pet {
    private int code;
    private String name;
    private String type;
    private LocalDate bornDate;
    private double weight;
    private Boolean gender;
    private String[] observations;

    public Pet(int code, String name, String type, LocalDate bornDate, double weight, Boolean gender, String[] observations) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.bornDate = bornDate;
        this.weight = weight;
        this.gender = gender;
        this.observations = observations;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public double getWeight() {
        return weight;
    }

    public Boolean getGender() {
        return gender;
    }

    public String[] getObservations() {
        return observations;
    }

    public String toString() {
        return "Pet{code=" + code + ", name='" + name + "', type='" + type + "', bornDate=" + bornDate + ", weight=" + weight + ", gender=" + gender + ", observations=" + java.util.Arrays.toString(observations) + "}";  
    }
}
