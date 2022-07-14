package org.li.L003;

import java.util.HashSet;

public class Main {
    static String DEMO = "abc1234abcabac";

    public static void main(String[] args) {
        int res = LongestSubString();
        System.out.println(res);
    }

    /**
     * 寻找最长的子串
     *
     * @return
     */
    private static int LongestSubString() {
        String[] strings = DEMO.split("");
        HashSet<Character> ooc = new HashSet<>();
        int n = DEMO.length();

        // 最长不重复子串
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                ooc.remove(DEMO.charAt(i - 1));
            }
            // 创建一个滑动窗口，在窗口中进行搜索
            int lastRightKey = searchInWindow(ooc);
            ans = Math.max(ans, lastRightKey + 1 - i);
        }
        return ans;
    }

    /**
     * 滑动窗口，在窗口内搜索重复字符串
     *
     * @param ooc
     */
    private static int searchInWindow(HashSet<Character> ooc) {
        int len = DEMO.length();
        // 右侧指针
        int rightKey = -1;
        // 向右不断地移动rightKey指针
        // 一直到出现重复子串 或者 到头了为止
        while (rightKey + 1 < len && !ooc.contains(DEMO.charAt(rightKey + 1))) {
            ooc.add(DEMO.charAt(rightKey + 1));
            ++rightKey;
        }
        return rightKey;
    }

}
