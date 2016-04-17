package com.epam;

import java.lang.ref.SoftReference;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long allocated = 0;
        SoftReference softReference = null;
        while (true) {
            softReference = new SoftReference<>(new Object());
            allocated++;
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            if (elapsed > 1000) {
                System.out.println("Allocated " + allocated + " in " + elapsed + " ms");
                allocated = 0;
                start = end;
            }
        }
    }
}
