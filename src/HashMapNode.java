import java.util.Objects;

public class HashMapNode<K, V> {

    private K key;
    private V value;
    private HashMapNode nextNode;

    public HashMapNode(K key, V value, HashMapNode nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashMapNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(HashMapNode nextNode) {
        this.nextNode = nextNode;
    }


}
