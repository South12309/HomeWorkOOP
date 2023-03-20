package algAndStruc;

public class ArrayListTest<E> implements ListTest<E>{
    private Object[] list;
    private int size=0;

    public ArrayListTest() {
        this.list = new Object[15];
    }

    @Override
    public boolean add(E e) {
        if (size>0)
            size++;
        list[size]=e;
        return true;
    }

    @Override
    public E get(int i) {
        chekIndex(i);
        return (E)list[i];
    }

    private void chekIndex(int i) {
        if (i >size)
            throw new RuntimeException("Индекс больше размера списка");
    }

    @Override
    public boolean set(int i, E e) {
        chekIndex(i);
        list[i]=e;
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
        return false;
    }

    @Override
    public boolean remove(int i) {
        return false;
    }
}
