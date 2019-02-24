package queue;

public interface Queue<E> {

    void insert(E value);
    E remove();
    E peek();

    // служебные
    int size();
    boolean isEmpty();
    boolean isFull();
}
