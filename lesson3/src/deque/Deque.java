package deque;

import queue.Queue;

public interface Deque<E> extends Queue<E> {

    // как в очереди
    E removeLeft();
    void insertRight(E value);

    // свои
    void insertLeft(E value);
    E removeRight();

}
