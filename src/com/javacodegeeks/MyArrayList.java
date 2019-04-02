package com.javacodegeeks;

public class MyArrayList {

    // initial size of array buffer
    private static final int INITIAL_SIZE = 10;

    // the array buffer
    private Integer[] array;
    
    // actual size of array buffer
    private int actualSize = 0;

    public MyArrayList() {
        array = new Integer[INITIAL_SIZE];
    }

    // Add element
    public void add(int element) {
        // resize array
        if (actualSize == array.length - 1) {
            Integer[] newArray = new Integer[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[actualSize++] = element;
    }

    // Remove element
    public boolean remove(int element) {
        // reorder array
        for (int i = 0; i < actualSize; i++) {
            if (array[i] == element) {
                for (int j = i; j < actualSize; j++) {
                    array[j] = array[j + 1];
                }
                actualSize--;
                return true;
            }
        }
        return false;
    }

    // Get by index
    public int get(int index) {
        if (index > 0 && index < actualSize) {
            return array[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    // Contains element
    public boolean contains(int element) {
        for (int i = 0; i < actualSize; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return actualSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < actualSize; i++) {
            builder.append(array[i]);
            builder.append(" ");
        }
        return builder.toString();
    }

    // Example
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("Initial ArrayList: " + list + "| size: " + list.size());
        System.out.println("Get index 2: " + list.get(2));
        System.out.println("Contains element 3: " + list.contains(2));
        System.out.println("-------------");
        System.out.println("Removing element 2: " + list.remove(2));
        System.out.println("ArrayList after removal: " + list + "| size: " + list.size());
        System.out.println("Get index 2: " + list.get(2));
        System.out.println("Contains element 3: " + list.contains(2));
    }
}