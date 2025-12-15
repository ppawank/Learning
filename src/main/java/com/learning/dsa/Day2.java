package com.learning.dsa;

import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        System.out.println("-----Day 2 Results----");
        Day2.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int pivotIndex = Day2.findPivotIndex(new int[]{1,7,3,6,5,6});
        System.out.println("Pivot Index :"+pivotIndex);

        System.out.println("List of kids with candies: "+ Day2.kidsWithCandies(new int[]{2,3,5,1,3},3));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        Boolean[] kids = new Boolean[candies.length];
        int max =0;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        for (int j = 0; j < candies.length; j++) {
            kids[j] =candies[j] + extraCandies>=max;
        }
        return Arrays.asList(kids);
    }

    private static int findPivotIndex(int[] nums) {
        int rsum=0;
        int lsum=0;
        for (int anInt : nums) {
            rsum += anInt;
        }

        for(int i=0;i<nums.length;i++){
            rsum=rsum-nums[i];
            if(lsum==rsum){
                return i;
            }
            lsum+=nums[i];
        }
        return -1;
    }

    public static void maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for (int num : nums) {

            sum += num;
            if(sum<0){
                sum=0;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println("Maximum Sum subarray: "+maxSum);
    }
}
