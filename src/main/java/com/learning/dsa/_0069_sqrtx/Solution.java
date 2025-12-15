package com.learning.dsa._0069_sqrtx;

class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }

        int low=0, high=x, ans=0;
        int mid; // computed in loop
        while(low<=high){
            mid = (low+high)/2;

            if(mid<=x/mid){
                low=mid+1;
                ans = mid;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tests = {0, 1, 4, 8, 16, 26, 2147395599}; // includes edge cases and large input
        for (int x : tests) {
            int sqrt = solution.mySqrt(x);
            System.out.println("mySqrt(" + x + ") = " + sqrt);
        }
    }
}
