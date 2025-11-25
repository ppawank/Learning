package com.learning.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        Day5 day5 = new Day5();
        System.out.println("Binary representation: " + day5.toBinary(67));
        System.out.println("Single Number: " + day5.singleNumber(new int[]{4,1,2,1,2}));
    }

    private int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    private String toBinary(int i) {
        List<Integer> list = new ArrayList<>();
        if (i == 0) {
            return "0";
        }
        while (i > 0) {
            list.add(i%2);
            i = i / 2;
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (Integer bit : list) {
            sb.append(bit);
        }
        return sb.toString();
    }
}
