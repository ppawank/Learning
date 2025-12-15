package com.learning.dsa._0326_power_of_three;

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tests = {1, 3, 9, 27, 0, -3, 45};
        for (int t : tests) {
            System.out.println(t + " -> " + solution.isPowerOfThree(t));
        }
    }
}