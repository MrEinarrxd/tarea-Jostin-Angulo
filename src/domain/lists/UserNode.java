package domain.lists;

import domain.users.User;

public class UserNode {
    private User user;
    private UserNode next;

    public UserNode(User user) {
        this.user = user;
        this.next = null;
    }

    public User getUser() {
        return user;
    }

    public UserNode getNext() {
        return next;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }

    public String toString() {
        return "UserNode{" + "user=" + user + ", next=" + next + '}';
    }
}
