package queue;

public class QueueImpl<E> implements Queue<E> {

    public static final int DEFAUL_END = -1;
    public static final int DEFAULT_BEGIN = 0;

    protected E[] data;
    protected int size;
    protected int begin;
    protected int end;

    public QueueImpl(int maxSize) {
        this.data = (E[])new Object[maxSize];
        this.size = 0;
        this.begin = DEFAULT_BEGIN;
        this.end = DEFAUL_END;
    }


    @Override
    public void insert(E value) {
        if(end == data.length - 1) {
            end = DEFAUL_END;
        }
        data[++end] = value;
        size++;
    }

    @Override
    public E remove() {
        E value = data[begin++];
        if(begin == data.length) {
            begin = DEFAULT_BEGIN;
        }
        size--;
        return value;
    }

    @Override
    public E peek() {
        return data[begin];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
