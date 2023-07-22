import java.util.HashMap;
import java.util.Objects;

class MyHashMap<K, V> {
    private static final int DEFAULT_BUCKET_QTY = 16;
    private int bucketQty = DEFAULT_BUCKET_QTY;

    private HashMapLinkedList[] bucketArray;
    private int size;

    public MyHashMap() {
        bucketArray = new HashMapLinkedList[DEFAULT_BUCKET_QTY];
        createBuckets(bucketArray, bucketArray.length);
        size = 0;
    }

    private void createBuckets(HashMapLinkedList[] bucketArray, int bucketQty) {
        for (int i = 0; i < bucketQty; i++) {
            bucketArray[i] = new HashMapLinkedList();
        }
    }

    private int getBucketNumber(Object key) {
        return Objects.hash(key) % bucketQty;
    }

    public void put(Object key, Object value) {
        if (size == bucketQty) {
            increaseBuckets();
        }
        addElementToBucket(key, value, bucketArray);
        size++;
    }

    // Increase q-ty of buckets in buckedArray and redistributes all elements
    private void increaseBuckets() {
        HashMapLinkedList[] newBucketArray = new HashMapLinkedList[bucketQty * 2];
        createBuckets(newBucketArray, newBucketArray.length);
        transferElementsToNewArray(bucketArray, newBucketArray);
        bucketArray = newBucketArray;
        bucketQty *= 2;
    }

    // Copy and redistributes all elements to new bucketArray
    private void transferElementsToNewArray(HashMapLinkedList[] bucketArray, HashMapLinkedList[] newBucketArray) {
        for (int i = 0; i < bucketQty; i++) {
            while (bucketArray[i].getFirstNode() != null) {
                addElementToBucket(bucketArray[i].getFirstNode().getKey(),
                        bucketArray[i].getFirstNode().getValue(),
                        newBucketArray);
                bucketArray[i].remove(bucketArray[i].getFirstNode().getKey());
            }
        }
    }

    private void addElementToBucket(Object key, Object value, HashMapLinkedList[] bucketArray) {
        int bucketNumber = getBucketNumber(key);
        bucketArray[bucketNumber].add(key, value);
    }


    public void remove(Object key) {
        int bucketNumber = Objects.hash(key) % bucketQty;
        bucketArray[bucketNumber].remove(key);
        size--;
    }

    public void clear() {
        bucketArray = new HashMapLinkedList[DEFAULT_BUCKET_QTY];
        createBuckets(bucketArray, bucketArray.length);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int bucketNumber = getBucketNumber(key);
        return bucketArray[bucketNumber].get(key);

    }
}
