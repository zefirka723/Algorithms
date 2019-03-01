package linkedList.twoside;

import linkedList.Entry;
import linkedList.SimpleLinkedListImpl;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Entry<E> lastElement;
    protected int currentSize;

    @Override
    public void insertLeft(E value) {
        super.insert(value);
        if (getSize() == 1) {
            lastElement = firstElement;
        }
    }


    @Override
    public E removeLeft() {
        E removedElement = super.remove();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedElement;
    }


    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;
        while (current != null) {
            if (current.getValue().equals(value)) {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        // Не нашёлся удаляемый элемент
        if (current == null) {
            return false;
        }

        // Удаляемый элемент найден
        if (current == firstElement) {
            firstElement = firstElement.getNext();
        } else if (current == lastElement) {
            lastElement = previous;
            previous.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        currentSize--;
        return true;
    }


    @Override
    public void insertRight(E value) {
        Entry<E> newElement = new Entry<>(value);
        if (isEmpty()) {
            firstElement = newElement;
        } else {
            lastElement.setNext(newElement);
        }
        lastElement = newElement;
        currentSize++;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void setSize(int size) {
        this.currentSize = size;
    }

}
