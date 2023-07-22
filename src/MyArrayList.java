import java.util.Arrays;

class MyArrayList<T> {

    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private Object[] values = new Object[DEFAULT_ARRAY_CAPACITY];
    private int size = 0;

    public void add(T value) {
        resize();
        values[size] = value;
        size++;
    }

    public void remove(int index) {
        if (size == 0) {
            return;
        } else if (size == 1) {
            clear();
        } else {
            for (int i = index; i < size - 1; i++) {
                values[i] = values[i + 1];
            }
            values[size - 1] = null;
            size--;
            resize();
        }
    }

    private void resize() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length * 2);
        }
    }

    public void clear() {
        values = new Object[DEFAULT_ARRAY_CAPACITY];
        size = 0;

    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) values[index];
    }

    @Override
    public String toString() {
        for (int i = 0; i < values.length; i++) {
            System.out.println("values[i] = " + values[i]);
        }
        return "";
    }
}

