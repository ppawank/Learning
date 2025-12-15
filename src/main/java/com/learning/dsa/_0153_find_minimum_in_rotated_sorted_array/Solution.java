package com.learning.dsa._0153_find_minimum_in_rotated_sorted_array;

class Solution {
    public int findMin(int[] nums) {
        int low=0,mid=0,high=nums.length-1;

        while(low<high){
            mid=(low+high)/2;

            if(nums[mid]>nums[high] ){
                low=mid+1;
            }else{
                high=mid;
            }

        }
        return nums[low];
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3,4,5,1,2})); // 1
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2})); // 0
        System.out.println(solution.findMin(new int[]{11,13,15,17})); // 11
    }
}