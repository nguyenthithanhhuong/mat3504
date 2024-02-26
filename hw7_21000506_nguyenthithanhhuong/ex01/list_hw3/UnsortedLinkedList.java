package hw7_21000506_nguyenthithanhhuong.ex01.list_hw3;

import java.util.Iterator;

public class UnsortedLinkedList<T extends Comparable<T>> implements ListInterface<T> {
    public class Node {
        public T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int size = 0;

    public void add(T data) {
        Node node = new Node();
        if (size == 0) {
            top = node;
            top.data = data;
            bot = node;
        } else {
            bot.next = node;
            bot = bot.next;
        }
        bot.data = data;
        size++;
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return getNode(i).data;
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node currentNode = top;
        while (index-- > 0) currentNode = currentNode.next;
        return currentNode;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node node = top;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
            node.data = data;
        }
    }

    public boolean isContain(T data) {
        Node node = top;
        for (int j = 0; j < size; j++) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public T removeTop() {
        T res = top.data;
        if (size == 0) return null;
        if (size == 1) {
            top = null;
            bot = null;
        } else {
            top = top.next;
        }
        size--;
        return res;
    }

    public T removeBot() {
        T res = bot.data;
        if (size == 0) return null;
        if (size == 1) {
            top = null;
            bot = null;
        } else {
            bot = getNode(size - 2);
        }
        size--;
        return null;
    }

    public void remove(T data) {
        if (size == 0) return;
        if (top.data.equals(data)) {
            top = top.next;
            size--;
            return;
        }
        Node node = top;
        Node deleteNode = null;
        while (node != null) {
            if (node.next.data.equals(data) && node.next != null) {
                deleteNode = node.next;
                node.next = deleteNode.next;
                size--;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    protected class LinkedListIterator implements Iterator<T> {
        private Node currentNode = top;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
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
