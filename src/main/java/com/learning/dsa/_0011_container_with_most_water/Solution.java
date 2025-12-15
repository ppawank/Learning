package com.learning.dsa._0011_container_with_most_water;

class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int low=0,high=height.length-1;

        while(low<high){
            final int minHeight = Math.min(height[low],height[high]);
            ans = Math.max( ans, minHeight * ( high - low) );
            if(height[low]<height[high]){
                ++low;
            }else{
                --high;
            }
            
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("maxArea = " + solution.maxArea(height));
    }
}