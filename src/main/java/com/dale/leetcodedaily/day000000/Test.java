package com.dale.leetcodedaily.day000000;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3}, b = {4,5,6,7};
        int[] temp = a;
        a = b;
        b = temp;
        for (int i : a) {
            System.out.println(i);
        }
        for (int i : b) {
            System.out.println(i);
        }
    }
}
