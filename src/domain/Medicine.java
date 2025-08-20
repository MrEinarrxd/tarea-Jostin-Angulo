package domain;
import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private String consume;
    private double amount;
    private LocalDate time;
    private LocalDate timeStart;
    private LocalDate timeTill;

    public Medicine(int id, String name, String consume, double amount, LocalDate time, LocalDate timeStart, LocalDate timeTill) {
        this.id = id;
        this.name = name;
        this.consume = consume;
        this.amount = amount;
        this.time = time;
        this.timeStart = timeStart;
        this.timeTill = timeTill;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConsume() {
        return consume;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTime() {
        return time;
    }

    public LocalDate getTimeStart() {
        return timeStart;
    }

    public LocalDate getTimeTill() {
        return timeTill;
    }

    public String toString() {
        return "{Medicine" + "id=" + id + ", name='" + name + "', consume='" + consume + "', amount=" + amount + ", time=" + time + ", timeStart=" + timeStart + ", timeTill=" + timeTill + "}";
    }
}
