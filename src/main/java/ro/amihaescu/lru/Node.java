package ro.amihaescu.lru;

public class Node<T> implements LinkedListNode<T> {
    private T value;
    private DoublyLinkedList<T> list;
    private LinkedListNode<T> next;
    private LinkedListNode<T> previous;

    public Node(T value, LinkedListNode<T> next, DoublyLinkedList<T> list) {
        this.value = value;
        this.next = next;
        this.setPrev(next.getPrev());
        this.previous.setNext(this);
        this.next.setPrev(this);
        this.list = list;
    }

    @Override
    public boolean hasElement() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getElement() throws NullPointerException {
        return value;
    }

    @Override
    public void detach() {
        this.previous.setPrev(this.getNext());
        this.next.setPrev(this.getPrev());
    }

    @Override
    public DoublyLinkedList<T> getListReference() {
        return this.list;
    }

    @Override
    public LinkedListNode<T> setPrev(LinkedListNode<T> prev) {
        this.previous = prev;
        return prev;
    }

    @Override
    public LinkedListNode<T> setNext(LinkedListNode<T> next) {
        this.next = next;
        return next;
    }

    @Override
    public LinkedListNode<T> getNext() {
        return this.next;
    }

    @Override
    public LinkedListNode<T> getPrev() {
        return this.previous;
    }

    @Override
    public LinkedListNode<T> search(T value) {
        return this.getElement() == value ? this : this.getNext().search(value);
    }
}
