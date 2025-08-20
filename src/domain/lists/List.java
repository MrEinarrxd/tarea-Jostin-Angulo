package domain.lists;

import domain.Date;
import domain.users.User;

public class List {
    private UserNode firstNode;
    private UserNode lastNode;
    // Date nodes
    private DateNode firstDateNode;
    private DateNode lastDateNode;

    public List() {
        this.firstNode = null;
        this.lastNode = null;
        this.firstDateNode = null;
        this.lastDateNode = null;
    }

    public void addUser(User newUser, List list) {
    if (list.getFirstUserNode() == null) {
        UserNode nodeObode = new UserNode(newUser);
        list.firstNode = nodeObode;
        list.lastNode = nodeObode;
    } else {
        UserNode nodeTwo = new UserNode(newUser);
        list.lastNode.setNext(nodeTwo);
        list.lastNode = nodeTwo;
    }}

    public UserNode getFirstUserNode() {
        return firstNode;
    }

    public UserNode getLastUserNode() {
        return lastNode;
    }

    public void setFirstUserNode(UserNode firstNode) {
        this.firstNode = firstNode;
    }

    public void setLastUserNode(UserNode lastNode) {
        this.lastNode = lastNode;
    }

    // Date nodes
    public void addDate(Date newDate, List list) {
        if (list.getFirstDateNode() == null) {
            DateNode nodeOne = new DateNode(newDate);
            list.firstDateNode = nodeOne;
            list.lastDateNode = nodeOne;
        } else {
            DateNode nodeTwo = new DateNode(newDate);
            list.lastDateNode.setNext(nodeTwo);
            list.lastDateNode = nodeTwo;
        }
    }

    public DateNode getFirstDateNode() {
        return firstDateNode;
    }

    public DateNode getLastDateNode() {
        return lastDateNode;
    }

    public void setFirstDateNode(DateNode firstDateNode) {
        this.firstDateNode = firstDateNode;
    }

    public void setLastDateNode(DateNode lastDateNode) {
        this.lastDateNode = lastDateNode;
    }
}