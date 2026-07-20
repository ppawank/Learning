package com.learning.dsa;

import java.util.HashMap;
import java.util.Map;

public class Day3 {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        System.out.println("Flower placed: " + day3.placeFlower(new int[]{0,0,1,0,0}, 1));
        //Leetcode:136
        System.out.println("Single number: " + day3.getSingleOccuranceNumber(new int[]{4,1,2,2,1}));
    }

    private String getSingleOccuranceNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey().toString();
            }
        }
        return "";
    }

    private boolean placeFlower(int[] flowerbed, int n) {
        int prevIndex = 0;
        int nextIndex = 0;

        if(n==0){
            return true;
        }

        if(n==1 && flowerbed.length==1 && flowerbed[0]==0){
            return true;
        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }
        if (n == 0) {
            return true;
        }
        for (int i = 1; i < flowerbed.length; i++) {
            prevIndex = i - 1;
            nextIndex = i + 1;
            if (nextIndex < flowerbed.length) {
                if (flowerbed[i] == 0 && flowerbed[prevIndex] == 0 && flowerbed[nextIndex] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
                if (n <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean placeFlower_v1(int[] flowerbed, int n) {
        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean prevEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }
}
