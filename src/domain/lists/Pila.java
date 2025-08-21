package domain.lists;

public class Pila implements LControllers {
    private UserNode top;

    public Pila() {
        this.top = null;
    }
    @Override
    public void insertar(UserNode node) {
        node.setNext(top);
        top = node;
    }
    
    @Override
    public UserNode eliminar() {
        if (top == null){
            return null;
        }
        UserNode removedNode = top;
        top = top.getNext();
        return removedNode;
    }
    @Override
    public UserNode Imprimir() {
        return top;
    }
}
