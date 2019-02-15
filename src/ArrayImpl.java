import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 16;
    protected static final int INVALID_INDEX = -1;

    protected E[] data;
    protected int currentSize;

    public ArrayImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public boolean remove(E value) {
        return removeByIndex(indexOf(value));
    }

    @Override
    public void remove(int index) {
        if (!removeByIndex(index)) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    private boolean removeByIndex(int index) {
        if (index == INVALID_INDEX || index < 0 || index >= currentSize) {
            return false;
        }
        for (int i = index; i < currentSize; i++) {
            data[i] = data[i + 1];
        }
        data[currentSize - 1] = null;
        currentSize--;
        return true;
    }


    @Override
    public void add(E value) {
        checkCapacity();
        data[currentSize++] = value;
    }

    void checkCapacity() {
        if (currentSize < data.length) {
            return;
        }
        data = Arrays.copyOf(data, (data.length == 0? 1 : data.length * 2));
    }


    @Override
    public boolean contains(E value) {
        return indexOf(value) == INVALID_INDEX ? false : true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return INVALID_INDEX;
    }


    @Override
    public void sortBubble() {
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    rearrange(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelection() {
        for (int i = 0; i < currentSize - 1; i++) {
            int minIndex = i;
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) < 0) {
                    minIndex = j;
                }
            }
            rearrange(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            E temp = data[i];
            int checking = i;
            while (checking > 0 && data[checking - 1].compareTo(temp) >= 0) {
                data[checking] = data[checking - 1];
                checking--;
            }
            data[checking] = temp;
        }
    }

    private void rearrange(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    @Override
    public int getSize() {
        return currentSize;
    }
}
