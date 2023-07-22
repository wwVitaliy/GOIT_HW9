class Node<T> {
    private T value;
    private Node<T> prevNode;
    private Node<T> nextNode;

    public Node(T value, Node<T> prevNode, Node<T> nextNode) {
        this.value = value;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
