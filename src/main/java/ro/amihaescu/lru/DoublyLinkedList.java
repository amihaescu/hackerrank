package ro.amihaescu.lru;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DoublyLinkedList<T> {

    private DummyNode<T> dummyNode;
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private AtomicInteger size;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public DoublyLinkedList() {
        this.dummyNode = new DummyNode<T>(this);
        clear();
    }

    private void clear() {
        this.lock.writeLock().lock();
        try {
            head = dummyNode;
            tail = dummyNode;
            size = new AtomicInteger(0);
        } finally {
            this.lock.writeLock().unlock();
            ;
        }
    }

    private int size() {
        this.lock.readLock().lock();
        try {
            return size.get();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public boolean isEmpty() {
        this.lock.readLock().lock();
        try {
            return head.isEmpty();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public boolean contains(T value) {
        this.lock.readLock().lock();
        try {
            return search(value).hasElement();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public LinkedListNode<T> search(T value) {
        this.lock.readLock().lock();
        try {
            return this.head.search(value);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public LinkedListNode<T> add(T value) {
        this.lock.writeLock().lock();
        try {
            head = new Node<T>(value, head, this);
            if (tail.isEmpty()) {
                tail = head;
            }
            size.incrementAndGet();
            return head;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public boolean addAll(Collection<T> values) {
        this.lock.writeLock().lock();
        try {
            for (T value : values) {
                if (add(value).isEmpty()) {
                    return false;
                }
            }
            return true;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public LinkedListNode<T> remove(T value) {
        this.lock.writeLock().lock();
        try {
            LinkedListNode<T> node = head.search(value);
            if (!node.isEmpty()) {
                if (node == tail) {
                    tail = tail.getPrev();
                }
                if (node == head) {
                    head = head.getNext();
                }
                node.detach();
                size.decrementAndGet();
            }
            return node;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public LinkedListNode<T> removeTail() {
        this.lock.writeLock().lock();
        try {
            LinkedListNode<T> oldTail = tail;
            if (tail == head) {
                tail = head = dummyNode;
            } else {
                tail = oldTail.getPrev();
                oldTail.detach();
            }
            if (!oldTail.isEmpty()) {
                size.decrementAndGet();
            }
            return oldTail;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public LinkedListNode<T> moveToFront(LinkedListNode<T> node) {
        return node.isEmpty() ? dummyNode : updateAndMoveToFront(node, node.getElement());
    }

    public LinkedListNode<T> updateAndMoveToFront(LinkedListNode<T> node, T newValue) {
        this.lock.writeLock().lock();
        try {
            if (node.isEmpty() || (this != node.getListReference())) {
                return dummyNode;
            }
            detach(node);
            add(newValue);
            return head;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    private void detach(LinkedListNode<T> node) {
        if (node != tail) {
            node.detach();
            if (node == head) {
                head = head.getNext();
            }
            size.decrementAndGet();
        } else {
            removeTail();
        }
    }


}
