package algAndStruc;


import java.util.LinkedList;

public class LinkedListTest<E> implements ListTest<E>{

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public E get(int i) {
        checkIndex(i);
        return node(i).item;
    }

    @Override
    public boolean set(int i, E e) {
        checkIndex(i);
        Node<E> x = node(i);
        x.item = e;
        return true;
    }


    @Override
    public int find(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (e.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(E e) {
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (e.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(int i) {
        checkIndex(i);
        unlink(node(i));
        return true;
    }

    @Override
    public String toString() {
        String listInString="[";

        listInString = listInString + first.item.toString();
        Node<E> next = first;
        for (int i = 1; i < size; i++) {
            next = next.next;
            listInString = listInString + ", " + next.item.toString();
        }
        listInString = listInString + "]";
        return "LinkedListTest{" +
                "list=" + listInString +
                ", size=" + size +
                '}';
    }

    private void checkIndex(int i) {
        if (!(i >= 0 && i <= size))
            throw new IndexOutOfBoundsException("Index: "+ i +", Size: "+size);
    }
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }
}
