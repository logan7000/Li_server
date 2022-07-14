package org.li.L001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 若找到了合适的数字（有且只有一种组合）
            int needNumber = target - nums[i];
            if (hashtable.containsKey(needNumber)) {
                return new int[]{hashtable.get(needNumber),i};
            }
            // 存储到hashtable中 {值：index}
            hashtable.put(nums[i], i);
        }
        // 循环一遍后发现，没有的话，返回空数组
        return new int[0];
    }
}
