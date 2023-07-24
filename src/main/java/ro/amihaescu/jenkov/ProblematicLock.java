package ro.amihaescu.jenkov;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class ProblematicLock implements MyLock {
    private volatile boolean locked = false;

    @Override
    public void lock() {
        while (this.locked) {

        }
        this.locked = true;
    }

    @Override
    public void unlock() {
        this.locked = false;

    }
}

interface MyLock {
    void lock();
    void unlock();
}

class CompareAndSwapLock implements MyLock {

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    @Override
    public void lock() {
        while (!this.atomicBoolean.compareAndSet(false, true)) {

        }
    }

    @Override
    public void unlock() {
        this.atomicBoolean.set(false);
    }
}

interface Counter {
    void increment();
    long get();
}

class OptimisticLockCounter implements Counter {

    private AtomicLong atomicLong = new AtomicLong();
    @Override
    public void increment() {
        boolean incSuccessful = false;
        while (!incSuccessful) {
            long value = this.atomicLong.get();
            long newValue = value + 1;
            incSuccessful = this.atomicLong.compareAndSet(value, newValue);
        }
    }

    @Override
    public long get() {
        return this.atomicLong.get();
    }
}
