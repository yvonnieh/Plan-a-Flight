//generic linkedlist

import java.io.*;

import javax.lang.model.util.ElementScanner6;

public class LinkedList<T> {
    // generic node class
    public class Node<T> {

        // Stores data of the node
        private T data;
        // Store address of the node
        private Node<T> next;

        // Constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Head of the node
    private Node<T> tail;
    private int len = 0; // Store length of the linked list

    // Constructors
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    // add a new element at the end
    public void add(T data) {

        // creating a new generic node
        Node<T> temp = new Node<T>(data);

        // check if list is empty
        if (this.head == null) {
            head = temp;
            tail = temp;
        }

        // if list exists
        else {
            tail.next = temp;
            tail = temp;
        }

        // Increase the len after adding new node
        len++;
    }

    // add a new node at the front of the list
    public void addToFront(T data) {
        // creating a new generic node
        Node<T> temp = new Node<T>(data);
        // Make the next of the newly allocated node to be the head
        temp.next = head;
        // make the head to be the newly allocated node
        head = temp;
        // Increase the len after adding new node
        len++;

    }

    // remove an element in the list
    public void remove(T data) {
        Node<T> prev = new Node<T>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> newtemp = head;
        boolean exists = false;

        // if head node needs to be deleted
        if (head.data == data) {
            head = head.next;
            exists = true;
        }

        // iterate over linkedlist
        while (newtemp.next != null) {

            // comparing value of data and current node
            if (String.valueOf(newtemp.data).equals(String.valueOf(data))) {
                prev.next = next;
                exists = true;
                break; // node found
            }

            // adjusting the list
            prev = newtemp;
            newtemp = newtemp.next;
            next = newtemp.next;
        }

        // comparing the last noe with the given data value
        if (exists == false && String.valueOf(newtemp.data).equals(String.valueOf(data))) {
            prev.next = null;
            exists = true;
        }
        // if node to be deleted exist
        if (exists) {
            len--;
        }
        // if node to be deleted does not exist
        else {
            System.out.println(
                    "The linked list does not contain the given value.");
        }
    }

    // return the length od the linkedlist
    public int size() {
        return this.len;
    }

    // clear the entire list
    public void clear() {
        head = null;
        len = 0;
    }

    // return true if the list is empty
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    // to display the linkedlist
    public String toString() {
        String S = "";
        Node<T> X = head;
        if (this.head == null)
            return null;
        while (X.next != null) {
            S += String.valueOf(X.data) + " ";
            X = X.next;
        }
        S += String.valueOf(X.data);
        return S;

    }

    public T get(int index) {
        int i = 0;
        Node<T> X = this.head;
        while (X != null) {
            if (i == index) {
                return X.data;
            }
            i++;
            X = X.next;
        }
        return null;
    }

    public T getFirst() {
        if (this.head != null)
            return head.data;
        else
            return null;
    }

    public T getLast() {
        if (this.tail != null) {
            return tail.data;
        } else
            return null;
    }

    public boolean contains(T data) {
        Node<T> X = this.head;
        while(X != null){
            if(X.data == data){
                return true;
            }
            X = X.next;
        }
        return false;
    }

}
