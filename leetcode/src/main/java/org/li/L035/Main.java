package org.li.L035;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int a = solution(nums, target);
    }

    /**
     * 找到对应的索引
     *
     * @param nums
     * @param target
     * @return
     */
    private static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 二分找对应下表
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
