package stack;

public interface Stack<E> {

    void push(E value);
    E pop();
    E peek();

    // служебные
    int size();
    boolean isEmpty();
    boolean isFull();

}
