package com.contour;

public class LinkedList implements ILinkedList {
    Node head;

    // Adding data at end
    public void insert(int data) {
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(null);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(true) {
                if (temp.getNext() != null) { temp = temp.getNext(); }
                else {
                    temp.setNext(newNode);
                    break;
                }
            }
        }
    }

    // returns the length of linked list
    public int length() {
        int count = 0;
        Node temp = head;
        while (true) {
            if (temp != null) {
                count++;
                temp = temp.getNext();
            } else { return count; }
        }
    }

    //Traversing Linked list
    public void traverse() {
        Node temp = head;
        while (true) {
            System.out.print(temp.getData());
            temp = temp.getNext();
            if (temp == null) {
                break;
            } else {
                System.out.print(" -> ");
            }
        }
    }

    // Search Function
    public int search(int data) {
        Node temp = head;
        int count = 1;
        while(true) {
            if (temp == null) {
                System.out.println("not found!");
                return -1;
            }
            if (temp.getData() == data) {
                return count;
            } else {
                temp = temp.getNext();
                count++;
            }
        }
    }

    // delete node of linked list using index
    public void delete(int index) {
        Node temp = head;
        if (index > this.length() || index < 1) {
            System.out.println("index out of bound!");
        } else if (index == 1) {
            head = head.getNext();
        } else {
            int count = 1;
            while(count < index - 1) {
                temp = temp.getNext();
                count++;
            }
            if (index == this.length()) {
                temp.setNext(null);
            } else {
                temp.setNext(temp.getNext().getNext());
            }
        }
    }
}
