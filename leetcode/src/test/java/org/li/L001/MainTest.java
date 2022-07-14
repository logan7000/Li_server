package org.li.L001;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Test;

public class MainTest extends TestCase {

    int[] nums = new int[]{1, 2, 3, 4, 5};
    int target = 2;

    @Test
    public void main() {
        Main main = new Main();
        main.twoSum(nums, target);
    }
}