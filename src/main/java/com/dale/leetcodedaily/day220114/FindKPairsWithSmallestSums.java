package com.dale.leetcodedaily.day220114;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    boolean flag = true;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        if (n > m) {
            flag = false;
            return kSmallestPairs(nums2, nums1, k);
        }
        Queue<int[]> q = new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]));
        for (int i = 0; i < Math.min(n, k); i++)
            q.add(new int[]{i, 0});
        List<List<Integer>> ans = new ArrayList<>();
        while (ans.size() < k && !q.isEmpty()) {
            int[] top = q.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(flag ? nums1[top[0]] : nums2[top[1]]);
            temp.add(flag ? nums2[top[1]] : nums1[top[0]]);
            ans.add(temp);
            if (top[1] + 1 < m)
                q.add(new int[]{top[0], top[1] + 1});
        }
        return ans;
    }
}

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        Solution s = new Solution();
        List<List<Integer>> ans = s.kSmallestPairs(nums1, nums2, 3);
        for (List<Integer> p : ans)
            System.out.printf("%d %d\n", p.get(0), p.get(1));
    }
}
