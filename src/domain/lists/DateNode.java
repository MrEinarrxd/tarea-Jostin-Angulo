package domain.lists;

import domain.Date;

public class DateNode {
    private Date date;
    private DateNode next;

    public DateNode(Date date) {
        this.date = date;
        this.next = null;
    }

    public Date getDate() {
        return date;
    }

    public DateNode getNext() {
        return next;
    }

    public void setNext(DateNode next) {
        this.next = next;
    }

}
