package domain;
import java.time.LocalDate;

public class Test {
    private int id;
    private LocalDate date;
    private String type;
    private String observations;

    public Test(int id, LocalDate date, String type, String observations) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.observations = observations;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getObservations() {
        return observations;
    }

    public String toString() {
        return "{Test" + "id=" + id + ", date=" + date + ", type='" + type + "', observations='" + observations + "}";
    }
}
