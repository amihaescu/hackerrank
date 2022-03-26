package ro.amihaescu.lru;

public interface LinkedListNode<T> {

    boolean hasElement();

    boolean isEmpty();

    T getElement() throws NullPointerException;

    void detach();

    DoublyLinkedList<T> getListReference();

    LinkedListNode<T> setPrev(LinkedListNode<T> prev);

    LinkedListNode<T> setNext(LinkedListNode<T> prev);

    LinkedListNode<T> getNext();

    LinkedListNode<T> getPrev();

    LinkedListNode<T> search(T value);

}
