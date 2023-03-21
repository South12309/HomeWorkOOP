package algAndStruc;

import java.util.Arrays;
import java.util.Objects;

public class ArrayListTest<E> implements ListTest<E> {
    private Object[] list;
    private int size = 0;

    public ArrayListTest() {
        this.list = new Object[15];
    }

    @Override
    public boolean add(E e) {
        list[size] = e;
        size++;
        return true;
    }

    @Override
    public E get(int i) {
        checkIndex(i);
        return (E) list[i];
    }

    private void checkIndex(int i) {
        if (i > size)
            throw new RuntimeException("Индекс больше размера списка");
    }

    @Override
    public boolean set(int i, E e) {
        checkIndex(i);
        list[i] = e;
        return true;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(e)) {
                return i;
            }
        }
        throw new RuntimeException("Элемент не найден в списке");
    }

    @Override
    public boolean remove(E e) {

        int i = 0;
        found:
        {
            if (e == null) {
                for (; i < size; i++)
                    if (list[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (e.equals(list[i]))
                        break found;
            }
            return false;
        }
        fastRemove(list, i);
        return true;
    }

    @Override
    public boolean remove(int i) {
        checkIndex(i);
        fastRemove(list, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public String toString() {
        String listInString="[";
        listInString = listInString + list[0].toString();
        for (int i = 1; i < size; i++) {
            listInString = listInString + ", " + list[i].toString();
        }
        listInString = listInString + "]";
        return "ArrayListTest{" +
                "list=" + listInString +
                ", size=" + size +
                '}';
    }
}
