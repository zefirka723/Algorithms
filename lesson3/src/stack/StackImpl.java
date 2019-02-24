package stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int size;

    // конструктор
    public StackImpl (int maxSize) {
        this.data = (E[])new Object[maxSize];
        this.size = 0;
    }

    @Override
    public void push(E value) {
        this.data[size++] = value;
    }

    @Override
    public E pop() {
        return data[--size];
    }

    @Override
    public E peek() {
        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==data.length;
    }
}
