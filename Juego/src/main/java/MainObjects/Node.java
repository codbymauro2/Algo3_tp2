package MainObjects;


public class Node<Data> {

    // ATRIBUTOS
    private Data data;
    private Node<Data> next;
    private Node<Data> previous;

    // METODOS

    // CONSTRUCTOR
    public Node(Data d) {
        data = d;
        next = null;
        previous = null;
    }

    // PRE: -
    // POST: cambia el nodo siguiente por ps
    public void changeNext(Node ps) {
        next = ps;
    }

    // PRE: -
    // POST: cambia el nodo anterior por ps
    public void changePrevious(Node ps) {
        previous = ps;
    }

    // PRE: -
    // POST: devuelve el nodo anterior
    public Node getPrevious() {
        return previous;
    }

    // PRE: -
    // POST: devuelve el nodo siguiente
    public Node getNext() {
        return next;
    }

    // PRE: -
    // POST: devuelve el dato que contiene el nodo
    public Data getData() {
        return data;
    }

};

