import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class DIYarrayList<T> implements List<T>, RandomAccess {

    private static final int DEFAULT_CAPACITY = 10;

    private static final String STR_UNSUPPORTED_OPERATION = "The requested operation is not supported.";

    private int size;
    private Object[] elements;

    public DIYarrayList() {
        elements = new Object[DEFAULT_CAPACITY];
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
    public boolean add(T t) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, newCapacity());
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        for (T t : c) {
            result |= add(t);
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldValue = (T) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public int indexOf(Object o) {
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null){
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(0)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }

    private int newCapacity() {
        return size<<1;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException(STR_UNSUPPORTED_OPERATION);
    }
}
