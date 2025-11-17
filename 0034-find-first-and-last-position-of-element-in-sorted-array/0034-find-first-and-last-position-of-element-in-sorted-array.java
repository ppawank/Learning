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
    
}