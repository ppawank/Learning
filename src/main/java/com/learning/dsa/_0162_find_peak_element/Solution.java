package com.learning.dsa._0162_find_peak_element;

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0,mid=0,ans=0,high=nums.length;

        if(high==1){
            return 0;
        }
        if(high==2){
         return nums[0]<nums[1] ? 1 : 0;
        }

        if(nums[0]>nums[1]){
            return 0;
        }

        if(nums[high-1]>nums[high-2]){
            return high-1;
        }
        low=1;
        high=nums.length-2;
        while(low<=high){
            mid=(low+high)/2;

            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                ans=mid;
                return ans;
            }else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(new int[]{1,2,3,1})); // 2
        System.out.println(solution.findPeakElement(new int[]{1,2,1,3,5,6,4})); // 5 or 1 depending on peaks
    }
}