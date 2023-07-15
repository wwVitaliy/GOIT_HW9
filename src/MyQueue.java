import java.util.Queue;

class MyQueueTest{
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        myQueue.clear();
        System.out.println("myQueue.peek() = " + myQueue.peek());
    }

}

class MyQueue<T> {
    private int size = 0;
    private Node<T> firstNode = null;
    private Node<T> lastNode = null;

    public void add(Object value){
        if (firstNode == null){
            firstNode = new Node<T>((T) value, null, null);
        }else if (lastNode == null){
            lastNode = new Node<>((T) value, firstNode, null);
            firstNode.setNextNode(lastNode);
        }else{
            lastNode.setNextNode(new Node<T>((T) value, lastNode, null));
            lastNode = lastNode.getNextNode();
        }
        size++;
    }
    public void clear(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public int size(){
        return size;
    }

    public T peek(){
        if (size == 0){
            return null;
        }
        return firstNode.getValue();
    }
    public T poll(){
        if (size == 0){
            return null;
        }
        T result = firstNode.getValue();
        firstNode.getNextNode().setPrevNode(null);
        firstNode = firstNode.getNextNode();
        size--;
        return result;
    }
}

