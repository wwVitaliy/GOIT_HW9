import java.util.Arrays;


class MyArrayList {

    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private int size = 0;
    private Object[] values = new Object[DEFAULT_ARRAY_CAPACITY];

    public void add(Object value){
        resize();
        values[size] = value;
        size++;
    };
    private void resize(){
        if (values.length == size){
            values = Arrays.copyOf(values, values.length + 5);
        }
        if (values.length - size > 5){
            values = Arrays.copyOf(values, values.length - 5);
        }
    }
    public void remove(int index){
        if (size == 0 ){
            return;
        }
        for (int i = index; i < size; i++) {
            values[i] = values[i+1];
        }
        values[size] = null;
        size--;
        resize();
    };
    public void clear(){
        for (int i = 0 ; i < size;i++){
            values[i] = null;
        }
        size = 0;
        Arrays.copyOf(values, DEFAULT_ARRAY_CAPACITY);
    }
    public int size(){
        System.out.println(values.length);
        return size;
    }

    public Object get(int index){
        return values[index];
    }
}

