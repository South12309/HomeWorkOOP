package algAndStruc;

public interface ListTest<E> {
    boolean add(E e);
    E get(int i);
    E set(int i, E e);
    int find(E e);
    boolean remove(E e);
    boolean remove(int i);

}
