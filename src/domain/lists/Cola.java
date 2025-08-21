package domain.lists;

public class Cola implements LControllers {
    private UserNode front;
    private UserNode rear;

    public Cola() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void insertar(UserNode node) {
        if (rear == null) {
            front = rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
    }

    @Override
    public UserNode eliminar() {
        if (front == null) {
            return null;
        }
        UserNode removedNode = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return removedNode;
    }

    @Override
    public UserNode Imprimir() {
        return front;
    }
}
