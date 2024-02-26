package hw7_21000506_nguyenthithanhhuong.ex01.list_hw3;

import java.util.Arrays;
import java.util.Iterator;

public class SortedArrayList<T extends Comparable<T>> implements ListInterface<T> {
    private T[] array;
    private int size = 0;
    private int DEFAULT_SIZE = 100;

    public SortedArrayList() {
        array = (T[]) new Comparable[DEFAULT_SIZE];
    }

    public SortedArrayList(int capacity) {
        array = (T[]) new Comparable[capacity];
    }

    @Override
    public void add(T data) {
        if (size == array.length) enlarge();

        int i = size;
        while (i > 0 && data.compareTo(array[i-1]) < 0) {
            array[i] = array[--i];
        }
        array[i] = data;
        size++;
    }

    protected void enlarge() {
        array = Arrays.copyOf(array, array.length*2);
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public void set(int i , T data) {
        if (i < 0 || i >= size) throw new ArrayIndexOutOfBoundsException();
        T setData = get(i);
        add(setData);
    }

    @Override
    public void remove(T data) {
        int key = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                key = i;
                break;
            }
        }
        if (key > -1) {
            for (int j = key; j < size; j++) {
                T temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        size--;
    }

    @Override
    public boolean isContain(T data) {
        return binarySearch(0, size - 1, data);
    }

    private boolean binarySearch(int first, int last, T key) {
        if (last < first) return false;
        int mid = (first + last)/2;
        if (array[mid].equals(key)) return true;
        if (array[mid].compareTo(key) < 0) {
            return binarySearch(mid + 1, last, key);
        }
        return binarySearch(first, mid - 1, key);
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
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    protected class ArrayListIterator implements Iterator<T> {
        protected int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            return array[currentIndex++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next()). append(", ");
        }

        if (sb.length() > 1) sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
