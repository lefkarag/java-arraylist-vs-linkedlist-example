package com.javacodegeeks;

public class MyLinkedList {

    // Node with data and reference to the next node
    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // head Node
    private Node head;
    
    // size of LinkedList
    private int size;

    // Add new element
    public void add(int element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
        } else {
            // traverse list to find last node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove element
    public boolean remove(int element) {
        if (head == null) {
            return false;
        }
        Node current = head;

        if (current == null) {
            return false;
        }

        // found in head
        if (current.data == element) {
            head = current.next;
            size--;
            return true;
        }

        // traverse list to find element
        while (current != null) {
            if (current.next != null && current.next.data == element) {
                size--;
                current.next = current.next.next;
                return true;
            }
        }
        return false;
    }

    // Get element by idex
    public int get(int index) {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index > 0 && index < size) {
            int count = 0;
            Node current = head;

            while (current != null) {
                if (index == count) {
                    return current.data;
                }
                current = current.next;
                count++;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    // Contains element
    public boolean contains(int element) {
        if (head == null) {
            return false;
        }
        Node current = head;
        
        while (current != null) {
            if (current.data == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Size
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = head;

        while (current != null) {
            builder.append(current.data);
            builder.append(" -> ");
            current = current.next;
        }
        return builder.toString();
    }

    // Example
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("Initial LinkedList: " + list + "| size: " + list.size());
        System.out.println("Get index 2: " + list.get(2));
        System.out.println("Contains element 3: " + list.contains(2));
        System.out.println("-------------");
        System.out.println("Removing element 2: " + list.remove(2));
        System.out.println("LinkedList after removal: " + list + "| size: " + list.size());
        System.out.println("Get index 2: " + list.get(2));
        System.out.println("Contains element 3: " + list.contains(2));
    }
}