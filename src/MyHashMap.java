import java.util.Objects;
class MyHashMap<K, V> {

    private static final int DEFAULT_BUCKET_QTY = 16;
    private int bucketQty = DEFAULT_BUCKET_QTY;

    private HashMapLinkedList[] bucketArray = new HashMapLinkedList[DEFAULT_BUCKET_QTY];

    public MyHashMap() {
        createBuckets();
    }
    private void createBuckets(){
        for (int i = 0; i < bucketQty; i++) {
            if (bucketArray[i] == null){
                bucketArray[i] = new HashMapLinkedList();
            }
        }
    }
    private int getBucketNumber(Object key){
        return Objects.hash(key) % bucketQty;
    }
    public void put(Object key, Object value){
        int bucketNumber = getBucketNumber(key);
        bucketArray[bucketNumber].add(key, value);
    }
    public void remove (Object key){
        int bucketNumber = Objects.hash(key) % bucketQty;
        bucketArray[bucketNumber].remove(key);
    }
    public void clear(){
        for (int i = 0; i < bucketQty; i++) {
            bucketArray[i].clear();
        }
    }
    public int size(){
        int result = 0;
        for (int i = 0; i < bucketQty; i++) {
            result += bucketArray[i].size();
        }
        return result;
    }
    public Object get (Object key){
        int bucketNumber = getBucketNumber(key);
        return  bucketArray[bucketNumber].get(key);

    }
}
