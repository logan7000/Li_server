package org.li.L977;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 19};
        int[] res = solution(nums);
    }

    /**
     * 有序数组二次方
     *
     * @param nums
     * @return
     */
    private static int[] solution(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int j = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[j--] = nums[l] * nums[l];
                l++;
            } else {
                res[j--] = nums[r] * nums[r];
                r++;
            }
        }
        return res;
    }
}
