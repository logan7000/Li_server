package org.li.L704;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int target = 3;
        int i = solution(nums, target);
        int i2 = solution2(nums, target);
        System.out.println(i);
    }

    /**
     * 二分查找
     * 因为有序
     *
     * @param nums
     * @param target
     * @return
     */
    private static int solution2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // 目标中位数
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int solution(int[] nums, int target) {

        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                res = i;
            }
        }
        return res;
    }
}
