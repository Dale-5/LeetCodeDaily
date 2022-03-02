package com.dale.leetcodedaily.day220110;

import java.util.ArrayList;
import java.util.List;

class Solution {
    String num;
    List<List<Integer>> list = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        this.num = num;
        return dfs(0);
    }

    boolean dfs(int idx) {
        if (idx == num.length())
            return list.size() > 2;
        List<Integer> curNum = new ArrayList<>();
        int max = num.charAt(idx) == '0' ? idx + 1 : num.length();
        for (int i = idx; i < max; i++) {
            curNum.add(0, num.charAt(i) - '0');
            if (list.size() < 2 || judge(curNum)) {
                list.add(curNum);
                if (dfs(i + 1))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    boolean judge(List<Integer> cur) {
        List<Integer> a = list.get(list.size() - 2), b = list.get(list.size() - 1), c = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size())
                t += a.get(i);
            if (i < b.size())
                t += b.get(i);
            c.add(t % 10);
            t /= 10;
        }
        if (t > 0)
            c.add(t);
        if (c.size() != cur.size())
            return false;
        for (int i = 0; i < c.size(); i++)
            if (c.get(i) != cur.get(i))
                return false;
        return true;
    }
}

public class AdditiveNumber {
    public static void main(String[] args) {
        String num = "199100199";
        Solution s = new Solution();
        System.out.println(s.isAdditiveNumber(num));
    }
}
