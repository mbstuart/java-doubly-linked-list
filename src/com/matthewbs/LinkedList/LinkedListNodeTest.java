package com.matthewbs.LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LinkedListNodeTest {

    private LinkedListNode node1;
    private LinkedListNode node2;
    private LinkedListNode node3;


    @Before
    public void setUp() {

        node1 = new LinkedListNode(1);
        node2 = new LinkedListNode(2);
        node3 = new LinkedListNode(3);

    }

    @Test
    public void NodeShouldBeAbleToAppendRightWhenNoNextNodeSet(){

        node1.appendNodeRight(node2);

        assertEquals(node2, node1.getNextNode());
    }

    @Test
    public void NodeShouldBeAbleToAppendLeftWhenNoPreviousNodeSet(){
        node1.appendNodeLeft(node2);

        assertEquals(node2, node1.getPreviousNode());
    }

    @Test
    public void AppendedNodeShouldHaveElementAsNextWhenAppendedLeft(){
        node1.appendNodeLeft(node2);

        assertEquals(node1, node2.getNextNode());
    }

    @Test
    public void AppendedNodeShouldHaveElementAsPreviousWhenAppendedRight(){

        node1.appendNodeRight(node2);

        assertEquals(node1, node2.getPreviousNode());
    }

    @Test
    public void NodeShouldBeAbleToAppendRightWhenNextNodeAlreadySet(){
        node1.appendNodeRight(node2);
        node1.appendNodeRight(node3);

        assertEquals(node3, node1.getNextNode());
    }

    @Test
    public void NodeShouldBeAbleToAppendRightAndOldNodeRetainsReference(){


        node1.appendNodeRight(node2);
        node1.appendNodeRight(node3);

        assertEquals(node3, node2.getPreviousNode());
    }

    @Test
    public void NodeShouldBeAbleToAppendLeftAndOldNodeRetainsReference(){

        node1.appendNodeLeft(node2);
        node1.appendNodeLeft(node3);

        assertEquals(node3, node2.getNextNode());
    }

    @Test
    public void AppendingLeftOnNode1WillMeanNode3HasNode2AsPrevious(){
        node1.appendNodeLeft(node2);
        node1.appendNodeLeft(node3);

        assertEquals(node2, node3.getPreviousNode());
    }

    @Test
    public void AppendingRightOnNode1WillMeanNode2HasNode3AsNext(){

        node1.appendNodeRight(node2);
        node1.appendNodeRight(node3);

        assertEquals(node2, node3.getNextNode());
    }

    @Test
    public void RemoveNodeShouldSetLeftToReferenceRight(){
        node2.appendNodeLeft(node1);
        node2.appendNodeRight(node3);

        node2.remove();

        assertEquals(node3, node1.getNextNode());

    }

    @Test
    public void RemoveNodeShouldSetRightToReferenceLeft(){

        node2.appendNodeLeft(node1);
        node2.appendNodeRight(node3);

        node2.remove();

        assertEquals(node1, node3.getPreviousNode());

    }
}