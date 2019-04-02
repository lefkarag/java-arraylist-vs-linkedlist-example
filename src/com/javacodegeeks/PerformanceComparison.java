package com.javacodegeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceComparison {

    static final int COUNT = 1000000;

    public static void main(String[] args) {
        System.out.println("*** ArrayList Performance ***");
        performanceRun(new ArrayList<>());

        System.out.println("\n*** LinkedList Performance ***");
        performanceRun(new LinkedList<>());
    }

    static void performanceRun(List<String> list) {
        for (int i = 0; i < COUNT; i++) {
            list.add(Integer.toString(i));
        }

        // add
        long now = System.currentTimeMillis();
        list.add("1");
        System.out.println("Add took: " + (System.currentTimeMillis() - now) + " ms");

        // get
        now = System.currentTimeMillis();
        list.get(COUNT / 2);
        System.out.println("Get took: " + (System.currentTimeMillis() - now) + " ms");

        // remove
        now = System.currentTimeMillis();
        list.remove(Integer.toString(1));
        System.out.println("Remove took: " + (System.currentTimeMillis() - now) + " ms");

        // contains
        now = System.currentTimeMillis();
        list.contains(Integer.toString(COUNT / 2));
        System.out.println("Contains took: " + (System.currentTimeMillis() - now) + " ms");
    }
}