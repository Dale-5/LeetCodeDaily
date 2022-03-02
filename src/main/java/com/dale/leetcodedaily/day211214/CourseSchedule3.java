package com.dale.leetcodedaily.day211214;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] x : courses) {
            sum += x[0];
            queue.add(x[0]);
            if (sum > x[1]) {
                sum -= queue.element();
                queue.remove();
            }
        }

        return queue.size();
    }
}

public class CourseSchedule3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] courses = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        System.out.println(solution.scheduleCourse(courses));
    }
}
