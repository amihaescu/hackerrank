package ro.amihaescu;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> integers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.containsKey( target - nums[i])) {
                result[0] = i;
                result[1] = integers.get(target - nums[i]);
                return result;
            } else {
                integers.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new TwoSum().twoSum(new int[]{3,2,4}, 6);
        System.out.println(result[0] + " " + result[1]);
    }

}