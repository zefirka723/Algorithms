package deque;

import queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public void insertRight(E value) {
        super.insert(value);
    }

    @Override
    public void insertLeft(E value) {
        if (begin - 1 < 0) {
            begin = data.length;
        }
        data[--begin] = value;
        size++;
    }


    @Override
    public E removeRight() {
        if (end < 0) {
            end = data.length - 1;
        }
        size--;
        return data[end--];
    }
}
