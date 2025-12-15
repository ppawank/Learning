package com.learning.dsa._0035_search_insert_position;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0,mid=0,high=nums.length-1;
        while(low<=high){
            mid=(low+high)/2;

            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,6};
        System.out.println(solution.searchInsert(nums, 5)); // 2
        System.out.println(solution.searchInsert(nums, 2)); // 1
        System.out.println(solution.searchInsert(nums, 7)); // 4
        System.out.println(solution.searchInsert(nums, 0)); // 0
    }
}