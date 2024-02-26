package hw7_21000506_nguyenthithanhhuong.ex01.list_hw3;

public interface ListInterface<E> extends Iterable<E> {
    void add(E data);
    E get ( int i);
    void set (int i , E data);
    void remove (E data);
    boolean isContain (E data);
    int size();
    boolean isEmpty();
}