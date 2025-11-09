package com.learning.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day4 {
    public static void main(String[] args) {
        Day4 day4 = new Day4();
        //Leetcode:1207
        System.out.println("Unique occurrences: " + day4.uniqueOccurrences(new int[]{1, 2}));

        //Leetcode:283
        System.out.print("Move Zeros: "+day4.moveZeroes(new int[]{0,1,0,3,12}));
    }

    private String moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        return nums.toString();
    }

    private boolean uniqueOccurrences(int[] nums) {
        boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : map.values())  {
            result = set.add(num);
            if (!result){
                break;
            }
        }
        return result;
    }
}
