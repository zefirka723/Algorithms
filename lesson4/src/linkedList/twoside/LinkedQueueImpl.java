package linkedList.twoside;

import queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {

    private TwoSideLinkedList<E> data;

    public LinkedQueueImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public void insert(E value) {
        data.insertRight(value);
    }

    @Override
    public E remove() {
        data.setSize(data.getSize() - 1);
        return data.removeLeft();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public void setSize(int size) {
        data.setSize(size);
    }
}
