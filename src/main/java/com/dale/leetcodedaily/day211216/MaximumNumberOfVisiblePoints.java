package com.dale.leetcodedaily.day211216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int same = 0, a = location.get(0), b = location.get(1);
        List<Double> polar = new ArrayList<>();
        for (List<Integer> point : points) {
            int x = point.get(0), y = point.get(1);
            if (x == a && y == b)
                same++;
            else
                polar.add(Math.atan2(y - b, x - a));
        }
        Collections.sort(polar);
        int n = polar.size();
        for (int i = 0; i < n; i++)
            polar.add(polar.get(i) + 2 * Math.PI);
        int maxN = 0, r = 0;
        for (int i = 0; i < polar.size(); i++) {
            while (r < polar.size() && polar.get(r) <= polar.get(i) + angle * Math.PI / 180)
                r++;
            maxN = Math.max(maxN, r - i);
        }
        return same + maxN;
    }
}

public class MaximumNumberOfVisiblePoints {

    public static void main(String[] args) {
        Solution1610 s = new Solution1610();
        int[][] p = {{2,1},{2,2},{3,4},{1,1}};
        List<List<Integer>> points = new ArrayList<>();
        for (int[] x : p) {
            List<Integer> dot = new ArrayList<>();
            dot.add(x[0]);
            dot.add(x[1]);
            points.add(dot);
        }
        int angle = 90;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(s.visiblePoints(points, angle, location));
    }
}
