package practice;

public class MyList<E> {
    private int capacity;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        capacity = 10;
    }

    public MyList(int capacity) {
        this.elements = new Object[capacity];
        this.capacity = capacity;
    }

    public void ensureCapacity() {
        int size = elements.length * 2;
        Object[] temp = new Object[size];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        elements = (E[]) temp;
        this.capacity = size;
    }

    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        Object[] temp = new Object[newSize];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        elements = (E[]) temp;
        this.capacity = newSize;

    }

    public boolean add(E element) {
        if (capacity == size) {
            ensureCapacity();
        } else {
            this.elements[size++] = element;
        }
        return true;
    }

    public void add(int index, E element) {
        if (capacity == size) {
            ensureCapacity();
        } else {
            for (int i = elements.length - 1; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            this.elements[index] = element;
            size++;
        }
    }

    public void print() {
        for (Object element : this.elements) {
            System.out.println(element);
        }
    }

    public E remove(int index) {
        E temp = (E) elements[index];
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        return temp;
    }

    public int size() {
        return size;
    }


    public E myClone() {
        Object[] temp = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        return (E) temp;
    }

    public boolean contains(E object) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == object) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E object) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == object) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E object) {
        for (int i = elements.length - 1; i > 0; i--) {
            if (elements[i] == object) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
