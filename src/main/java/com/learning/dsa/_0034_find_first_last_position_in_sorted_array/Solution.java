package com.learning.dsa._0034_find_first_last_position_in_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int [] ans=new int[]{-1,-1};
        if(nums.length<=0){
            return ans;
        }
        ans[0]=firstIndex(nums,target);
        ans[1]=lastIndex(nums,target);
        return ans;
    }
    
    public int firstIndex(int[] nums,int target){
        int low=0,mid=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            mid=(low+high)/2;

            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }            
        }
        return ans;
    }

    public int lastIndex(int[] nums,int target){
        int low=0,mid=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            mid=(low+high)/2;

            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int[] res = solution.searchRange(nums, 8); // [3,4]
        System.out.println("[" + res[0] + "," + res[1] + "]");
        int[] res2 = solution.searchRange(nums, 6); // [-1,-1]
        System.out.println("[" + res2[0] + "," + res2[1] + "]");
    }
}