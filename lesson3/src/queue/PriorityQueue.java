package queue;

public class PriorityQueue<E extends Object & Comparable<? super E>> extends QueueImpl<E> {

    public PriorityQueue(int maxSize) {
        super(maxSize);
        this.data = (E[])new Object[maxSize];
    }

    @Override
    public void insert(E value) {
        if(isEmpty()) {
            data[size++] = value;
            return;
        }
        int i;
        for (i = size - 1; i >= 0; i--) {
            if(value.compareTo(data[i]) > 0) {
                data[i+1] = data[i];
            }
            else {
                break;
            }
        }
        data[i+1] = value;
        size++;
    }

    @Override
    public E remove() {
        return data[--size];
    }

    @Override
    public E peek() {
        return data[size - 1];
    }
}
