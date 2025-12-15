package com.learning.dsa._0075_sort_colors;

class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0,mid=0,high=n-1;

        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }else{
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);
        System.out.print("Sorted: [");
        for (int i=0;i<nums.length;i++) {
            System.out.print(nums[i]);
            if(i<nums.length-1) System.out.print(",");
        }
        System.out.println("]");
    }
}