package linkedList;

import linkedList.iterator.MyIterator;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    private int currentSize;


    @Override
    public void insert(E value) {
        Entry<E> newElement = new Entry<E>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        currentSize++;
    }

    @Override
    public E remove() { // удаление из начала списка
        if (isEmpty()) {
            return null;
        }
        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();
        currentSize--;
        return removedElement.getValue();
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
            firstElement = firstElement.getNext(); // удаляем текущий
        }
        else {
            previous.setNext(current.getNext());
        }
        currentSize--;
        return true;
    }



    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public void setSize(int size) {
        currentSize = size;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("----");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }

        System.out.println("----");
    }

    @Override
    public E getFirstElement() {
        return firstElement.getValue();
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<Entry> iterator() {
        return new MyIterator<>();
    }

}
