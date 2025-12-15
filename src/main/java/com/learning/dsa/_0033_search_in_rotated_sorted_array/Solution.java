package com.learning.dsa._0033_search_in_rotated_sorted_array;

class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int mid;

        while(low<=high){
            mid=(low+high)/2;
            
            if(nums[mid]==target){
                return mid;
            }

            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }             
            }else{
                if(nums[mid]< target && target<=nums[high]){
                     low=mid+1;
                }
                else{
                    high=mid-1;
                }                               
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 0)); // 4
        System.out.println(solution.search(nums, 3)); // -1
        System.out.println(solution.search(new int[]{1}, 0)); // -1
    }
}