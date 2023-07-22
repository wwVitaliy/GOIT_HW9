import java.util.LinkedList;

public class ListTests {
    public static void main(String[] args) {

        myArrayListTest();
//        myLinkedListTest();
//        myQueueTest();
//        myStackTest();
//        myHashMapTest();
    }

    private static int n = 1000000;    // Number of elements in Collection

    public static void myArrayListTest() {
        System.out.println("-------------------------------------- MyArrayList test");

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        // Test myArraylist.add() method
        for (int i = 0; i < n; i++) {
            myArrayList.add(i);
        }
        System.out.println("myArrayList.size() = " + myArrayList.size());

        // Test MyArrayList.remove() and MyArrayList.get() methods
        for (int i = 0; i < 10; i++) {
            System.out.println("myArrayList.remove(i) = " + myArrayList.get(i));
            myArrayList.remove(i);
        }

        // Test MyArrayList.clear() and MyArrayList.size() methods
        System.out.println("myArrayList.size() before clear() = " + myArrayList.size());
        myArrayList.clear();
        System.out.println("myArrayList.size() after clear() = " + myArrayList.size());

    }

    public static void myLinkedListTest() {
        System.out.println("-------------------------------------- MyLinkedList test");

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        // Test myLinkedList.add() method
        for (int i = 0; i < n; i++) {
            myLinkedList.add(i);
        }
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        // Test MyLinkedList.remove() and MyLinkedList.get() methods
        for (int i = 0; i < 10; i++) {
            myLinkedList.remove(i);
            System.out.println("myLinkedList.remove(i) = " + myLinkedList.get(i));
        }

        // Test MyLinkedList.clear() and MyLinkedList.size() methods
        System.out.println("myLinkedList.size() before clear() = " + myLinkedList.size());
        myLinkedList.clear();
        System.out.println("myLinkedList.size() after clear() = " + myLinkedList.size());

    }

    public static void myQueueTest() {
        System.out.println("-------------------------------------- MyQueue test");

        MyQueue<Integer> myQueue = new MyQueue<>();

        // Test myQueue.add() method
        for (int i = 0; i < n; i++) {
            myQueue.add(i);
        }
        System.out.println("myQueue.size() = " + myQueue.size());

        // Test MyQueue.poll() and MyQueue.peek() methods
        for (int i = 0; i < 10; i++) {
            System.out.println("myQueue.get = " + myQueue.peek());
            System.out.println("myQueue.poll() = " + myQueue.poll());
        }

        // Test MyQueue.clear() and MyQueue.size() methods
        System.out.println("myQueue.size() before clear() = " + myQueue.size());
        myQueue.clear();
        System.out.println("myQueue.size() after clear() = " + myQueue.size());

    }

    public static void myStackTest() {
        System.out.println("-------------------------------------- MyStack test");

        MyStack<Integer> myStack = new MyStack<>();

        // Test myStack.add() method
        for (int i = 0; i < n; i++) {
            myStack.push(i);
        }
        System.out.println("myStack.size() = " + myStack.size());

        // Test MyStack.pop() and MyStack.peek() methods
        for (int i = 0; i < 10; i++) {
            System.out.println("myStack.get = " + myStack.peek());
            System.out.println("myStack.poll() = " + myStack.pop());
        }

        // Test myStack.remove() method
        System.out.println("myStack.size() before remove() = " + myStack.size());
        myStack.remove(0);
        System.out.println("myStack.size() after remove() = " + myStack.size());


        // Test MyStack.clear() and MyStack.size() methods
        System.out.println("myStack.size() before clear() = " + myStack.size());
        myStack.clear();
        System.out.println("myStack.size() after clear() = " + myStack.size());

    }

    public static void myHashMapTest() {
        System.out.println("-------------------------------------- MyHashMap test");

        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        // Test myHashMap.put() method
        for (int i = 0; i < n; i++) {
            myHashMap.put(i, i * 10);
        }
        System.out.println("myHashMap.size() = " + myHashMap.size());

        // Test myHashMap.get() myHashMap.remove() and method
        for (int i = 0; i < 10; i++) {
            System.out.println("myHashMap.get(i) before remove(i) = " + myHashMap.get(i));
            myHashMap.remove(i);
            System.out.println("myHashMap.get(i) after remove(i) = " + myHashMap.get(i));
        }

        // Test myHashMap.clear() and myHashMap.size() methods
        System.out.println("myHashMap.size() before clear() = " + myHashMap.size());
        myHashMap.clear();
        System.out.println("myHashMap.size() after clear() = " + myHashMap.size());

    }
}
