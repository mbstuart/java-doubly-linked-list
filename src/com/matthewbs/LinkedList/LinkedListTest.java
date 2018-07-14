package com.matthewbs.LinkedList;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    private LinkedList testList;
    private int nodeValue1;
    private int nodeValue2;

    @Before
    public void setUp() {
        testList = new LinkedList();
        nodeValue1 = 1;
        nodeValue2 = 2;
    }

    @Test
    public void LinkedListShouldAddElementAsFirstIfNoFirstElementSpecified(){

        testList.appendToStart(nodeValue1);

        assertEquals(testList.getFirstValue(), nodeValue1);
    }

    @Test
    public void LinkedListShouldAddElementAsSecondIfNoFirstElementSpecified(){
        testList.appendToStart(nodeValue1);
        assertEquals(testList.getLastValue(), nodeValue1);
    }



    @Test
    public void LinkedListShouldAddElementAsFirstElementSpecified(){
        testList.appendToStart(nodeValue1);
        testList.appendToStart(nodeValue2);

        assertEquals(testList.getFirstValue(), nodeValue2);
    }

    @Test
    public void LinkedListShouldAddElementAsFirstIfNoFirstElementSpecifiedOnAppendLast(){
        testList.appendToEnd(nodeValue1);

        assertEquals(testList.getLastValue(), nodeValue1);
    }

    @Test
    public void LinkedListShouldAddElementAsSecondIfNoFirstElementSpecifiedOnAppendLast(){
        testList.appendToEnd(nodeValue1);
        assertEquals(testList.getFirstValue(), nodeValue1);

    }



    @Test
    public void LinkedListShouldAddElementAsFirstElementSpecifiedOnAppendLast(){
        testList.appendToEnd(nodeValue1);
        testList.appendToEnd(nodeValue2);

        assertEquals(testList.getLastValue(), nodeValue2);
    }

    @Test
    public void RemovalByIndexShouldCorrectlyRemoveElement(){
        testList.appendToStart(nodeValue1);
        testList.appendToStart(nodeValue2);

        testList.removeAtIndex(1);
        assertEquals(nodeValue2,testList.getFirstValue());

    }
}