package linkedList.iterator;

import linkedList.Entry;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {

    private Entry<E> entry;

    @Override
    public boolean hasNext() {
        if (entry.getNext() == null) {
            return false;
        }
        return true;
    }

    @Override
    public E next() {
        Entry<E> next = entry.getNext();
        return next.getValue();
    }
}
