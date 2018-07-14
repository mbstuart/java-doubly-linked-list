package com.matthewbs.LinkedList;

class LinkedListNode<T> {

    /**
     * Stored int value
     */
    private T value;

    public T getValue() {
        return value;
    }

    private void setValue(T value) {
        this.value = value;
    }

    private LinkedListNode previousNode;

    public LinkedListNode getPreviousNode() {
        return previousNode;
    }

    private void setPreviousNode(LinkedListNode previousNode) {
        this.previousNode = previousNode;
    }

    private LinkedListNode nextNode;

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public LinkedListNode(T value) {
        this.setValue(value);
    }

    private void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    public void appendNodeRight(LinkedListNode node){
        LinkedListNode nextNode = this.getNextNode();
        if(nextNode != null){
            nextNode.setPreviousNode(node);
            node.setNextNode(nextNode);
        }
        node.setPreviousNode(this);
        this.setNextNode(node);
    }

    public void appendNodeLeft(LinkedListNode node){
        LinkedListNode previousNode = this.getPreviousNode();

        if(previousNode != null){
            previousNode.setNextNode(node);
            node.setPreviousNode(previousNode);
        }

        node.setNextNode(this);
        this.setPreviousNode(node);
    }

    public void remove(){
        LinkedListNode previous = this.getPreviousNode();
        LinkedListNode next = this.getNextNode();

        if(previous != null){
            previous.setNextNode(next);
        }

        if(next != null){
            next.setPreviousNode(previous);
        }

    }
}
