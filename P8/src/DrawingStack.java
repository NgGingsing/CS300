//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingStack.java
// Files:           AsciiArt.java, AsciiTest.java, Canvas.java, DrawingChange.
//                  java, DrawingStack.java, DrawingStackIterator.java
// Course:          CS300 Fall 2018
//
// Author:          Bryce Xu
// Email:           xxu373@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jingcheng Wu
// Partner Email:   jwu446@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

public class DrawingStack implements StackADT<DrawingChange>
{
    Node<DrawingChange> top;
    int size;

    public DrawingStack()
    {
        top = null;
        size = 0;
    }

    @Override
    public void push(DrawingChange element) throws IllegalArgumentException
    {
        Node<DrawingChange> newNode = new Node<>(element, top);
        top = newNode;
        size++;
    }

    @Override
    public DrawingChange pop()
    {
        if (isEmpty())
        {
            throw new NullPointerException(
                    "WARNING: The Stack is empty. Unable " + "to execute a pop operation."
            );
        }
        DrawingChange remove = top.getData();
        top = top.getNext();
        size--;
        return remove;
    }

    @Override
    public DrawingChange peek()
    {
        if (isEmpty())
        {
            throw new NullPointerException(
                    "WARNING: The Stack is empty. Unable " + "to execute a pop operation."
            );
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty()
    {
        return top == null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Iterator<DrawingChange> iterator()
    {
        return new DrawingStackIterator(top);
    }
}









