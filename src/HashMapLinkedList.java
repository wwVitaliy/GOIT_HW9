class HashMapLinkedList<K, V> {

    private int size = 0;
    private HashMapNode<K, V> firstNode = null;
    private HashMapNode<K, V> lastNode = null;

    public HashMapNode<K, V> getFirstNode() {
        return firstNode;
    }
    public HashMapNode<K, V> getLastNode() {
        return lastNode;
    }

    public int size() {
        return size;
    }
    private void addToTheEnd(K key, V value) {
        if (firstNode == null) {
            firstNode = new HashMapNode<>(key, value, null);
        } else if (lastNode == null) {
            lastNode = new HashMapNode<>(key, value, null);
            firstNode.setNextNode(lastNode);
        } else {
            lastNode.setNextNode(new HashMapNode<>(key, value, null));
            lastNode = lastNode.getNextNode();
        }
        size++;

    }
    public void add(K key, V value){
        boolean hasKey = false;
        HashMapNode<K, V> node = firstNode;
        for (int i = 0; i < size; i++) {
            if (node.getKey().equals(key)){
                node.setValue(value);
                hasKey = true;
                break;
            }
            node = node.getNextNode();

        }
        if (!hasKey){
            addToTheEnd(key, value);
        }

    }
    public void remove(K key) {
        if (size == 0) {
            System.out.println("Bucket is empty");
            return;
        }
        if (firstNode.getKey().equals(key)) {
            firstNode = firstNode.getNextNode();
            size--;
        } else {
            HashMapNode<K, V> node = firstNode;
            for (int i = 1; i < size; i++) {
                if (node.getNextNode().getKey().equals(key)) {
                    node.setNextNode(node.getNextNode().getNextNode());
                    size--;
                    break;
                }
                node = node.getNextNode();
            }
        }
        if (size <= 1){
            lastNode = null;
        }
    }
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public V get(K key){
        HashMapNode<K, V> node = firstNode;
        for (int i = 0; i < size; i++) {
            if (node.getKey().equals(key)){
                return node.getValue();
            }
            node = node.getNextNode();

        }
        return null;
    }
    @Override
    public String toString() {
        String result = "";
        if (size > 0) {
            HashMapNode<K, V> node = firstNode;
            result += "{" + node.getKey() + " " + node.getValue() + "}";
            while (node.getNextNode() != null) {
                result += ", {" + node.getNextNode().getKey() + " " + node.getNextNode().getValue() + "}";
                node = node.getNextNode();
            }
        }
        return "{" + result + "}";
    }
}
