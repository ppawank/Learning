package com.learning.dsa._0704_binary_search;

class Solution {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            if(target>nums[mid]) low=mid+1; else high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(solution.search(nums, 9)); // 4
        System.out.println(solution.search(nums, 2)); // -1
    }
}