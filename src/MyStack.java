class MyStack<T> {
    private int size = 0;
    private Node<T> firstNode = null;
    private Node<T> lastNode = null;

    public void push(Object value) {
        if (firstNode == null) {
            firstNode = new Node<T>((T) value, null, null);
        } else if (lastNode == null) {
            lastNode = new Node<T>((T) value, firstNode, null);
            firstNode.setNextNode(lastNode);
        } else {
            lastNode.setNextNode(new Node<>((T) value, lastNode, null));
            lastNode = lastNode.getNextNode();
        }
        size++;
    }

    public void remove(int index) {
        if (index > size || index < 1) {
            return;
        }
        if (index == 1) {
            firstNode = firstNode.getNextNode();
            firstNode.setPrevNode(null);
        } else if (index == size) {
            lastNode = lastNode.getPrevNode();
            lastNode.setNextNode(null);
        } else {
            Node<T> nodeToRemove = firstNode.getNextNode();
            for (int i = 2; i < index; i++) {
                nodeToRemove = nodeToRemove.getNextNode();
            }
            nodeToRemove.getPrevNode().setNextNode(nodeToRemove.getNextNode());
            nodeToRemove.getNextNode().setPrevNode(nodeToRemove.getPrevNode());
            size--;
        }


    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return firstNode.getValue();
        } else {
            return lastNode.getValue();
        }
    }

    public T pop() {
        T result = null;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            result = firstNode.getValue();
            firstNode = null;
        } else {
            result = lastNode.getValue();
            lastNode.getPrevNode().setNextNode(null);
            lastNode = lastNode.getPrevNode();
        }
        size--;
        return result;
    }


}
