package ro.amihaescu.lru;

public class DummyNode<T> implements LinkedListNode<T> {

    private DoublyLinkedList<T> linkedList;

    public DummyNode(DoublyLinkedList<T> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public boolean hasElement() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T getElement() throws NullPointerException {
        throw new NullPointerException();
    }

    @Override
    public void detach() {
        return;
    }

    @Override
    public DoublyLinkedList<T> getListReference() {
        return linkedList;
    }

    @Override
    public LinkedListNode<T> setPrev(LinkedListNode<T> prev) {
        return prev;
    }

    @Override
    public LinkedListNode<T> setNext(LinkedListNode<T> prev) {
        return prev;
    }

    @Override
    public LinkedListNode<T> getNext() {
        return this;
    }

    @Override
    public LinkedListNode<T> getPrev() {
        return this;
    }

    @Override
    public LinkedListNode<T> search(T value) {
        return this;
    }
}
