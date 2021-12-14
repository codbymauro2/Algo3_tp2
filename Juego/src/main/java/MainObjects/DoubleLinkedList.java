package MainObjects;


public class
DoubleLinkedList<Data> {

    // ATRBUTOS

    // NODOS LISTA COMUN
    private Node<Data> first;
    private Node<Data> last;
    private Node<Data> current;
    private Node<Data> previous;
    private int length;

    public DoubleLinkedList() {
        first = null;
        current = null;
        length = 0;
        last = null;
        previous = null;
    }

    public void insert(Data d) {
        Node<Data> newNode = new Node<Data>(d);
    /*if(length == 0)
        first = nullptr;*/
        if(first == null){
            newNode.changeNext(first);
            first = newNode;
            current = first;
            last = current;
        }
        else{
            Node<Data> previous = last;
            newNode.changeNext(previous.getNext());
            previous.changeNext(newNode);
            newNode.changePrevious(last);
            last = newNode;
        }
        length++;
    }


    public void erase(int pos) {

        Node<Data> erased = first;

        if (pos == 1)
            first = erased.getNext();
        else {
            Node<Data> previous = getNode(pos - 1);
            erased = previous.getNext();
            previous.changeNext(erased.getNext());
        }
        length--;

    }


    public boolean isEmpty() {
        return length==0;
    }

    public Data getData(int pos) {
        Node<Data> aux = getNode(pos);
        return aux.getData();
    }

    public int getLength() {
        return length;
    }

    public boolean hasNext() {
        return (current != null);
    }


    public boolean hasPrevious() {
        return (previous != null);
    }

    public void reset() {
        current = first;
        previous = null;
    }

    public Node<Data> getNext() {
        previous = current;
        Node<Data> aux = current;
        current = current.getNext();

        return aux;
    }


    public Node<Data> getCurrent() {
        return current;
    }

    public void goForward() {
        previous = current;
        current = current.getNext();
    }

    public Node<Data> getPrevious() {
        return previous.getPrevious();
    }

    private Node<Data> getNode(int pos) {
        Node<Data> aux = first;
        for(int i = 1; i < pos; i++)
            aux = aux.getNext();
        return aux;
    }
};


