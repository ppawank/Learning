class Solution {
    public int findPeakElement(int[] nums) {
        int low=0,mid=0,ans=0,high=nums.length;

        if(high==1){
            return 0;
        }
        if(high==2){
         if(nums[0]<nums[1])  {
            return 1;
         }else{
            return 0;
         }
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
}