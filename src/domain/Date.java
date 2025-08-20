package domain;
import java.time.LocalDate;

import domain.users.User;

public class Date {
    private int id;
    private LocalDate date;
    private String about;
    private int state;//from 0 to 3 4 the 4 states
    private LocalDate time;
    private User user;// user associated with the date

    public Date(int id, LocalDate date, String about, int state, LocalDate time, User user) {
        this.id = id;
        this.date = date;
        this.about = about;
        this.state = state;
        this.time = time;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAbout() {
        return about;
    }

    public int getState() {
        return state;
    }

    public LocalDate getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public String toString() {
        return "{Date" + "id=" + id + ", date=" + date + ", about='" + about + "', state=" + state + ", time=" + time + ", user=" + user + "}";
    }
}
