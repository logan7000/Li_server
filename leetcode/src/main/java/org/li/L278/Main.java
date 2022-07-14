package org.li.L278;

public class Main {
    public static void main(String[] args) {
        test(0);
    }

    private static boolean isBadVersion(int version) {
        return true;
    }

    private static int test(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // 检查结果
            boolean res = isBadVersion(mid);
            if (res == true) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
