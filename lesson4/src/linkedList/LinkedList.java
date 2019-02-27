package linkedList;

public interface LinkedList<E> extends Iterable<Entry> {

    void insert(E value);
    E remove();

    boolean remove(E value);

    boolean isEmpty();
    int getSize();
    void setSize(int size);

    boolean contains(E value);

    void display();

    E getFirstElement();

    Entry<E> getFirst();

}
