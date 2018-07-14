package com.matthewbs.LinkedList;

public class LinkedList<T> {

    private LinkedListNode<T> firstNode;

    private LinkedListNode<T> lastNode;


    public LinkedList(){
    }


    public LinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    private void setFirstNode(LinkedListNode<T> firstNode) {
        this.firstNode = firstNode;
    }

    public T getFirstValue() {
        return this.firstNode.getValue();
    }

    public LinkedListNode<T> getLastNode() {
        return lastNode;
    }

    private void setLastNode(LinkedListNode<T> lastNode) {
        this.lastNode = lastNode;
    }

    public T getLastValue() {
        return this.lastNode.getValue();
    }

    public void appendToStart(T value){
        LinkedListNode<T> node = new LinkedListNode<T>(value);

        LinkedListNode<T> firstNode = this.getFirstNode();
        if(firstNode != null){
            firstNode.appendNodeLeft(node);
        } else {
            this.setLastNode(node);
        }
        this.setFirstNode(node);

    }

    public void appendToEnd(T value){
        LinkedListNode<T> node = new LinkedListNode<T>(value);

        LinkedListNode<T> lastNode = this.getLastNode();
        if(lastNode != null){
            lastNode.appendNodeRight(node);
        } else {
            this.setFirstNode(node);
        }
        this.setLastNode(node);

    }

    public void removeAtIndex(int i) {
        LinkedListNode<T> currentNode = this.getFirstNode();
        while(i > 0) {
            currentNode = currentNode.getNextNode();
            if(currentNode == null) {
                throw new IndexOutOfBoundsException();
            }
            i = i - 1;
        }

        if(currentNode.getNextNode() == null){
            this.setLastNode(currentNode.getPreviousNode());
        }

        if(currentNode.getPreviousNode() == null){
            this.setFirstNode(currentNode.getNextNode());
        }

        currentNode.remove();
    }


}
