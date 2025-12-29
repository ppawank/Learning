class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;

        for(right=0;right<nums.length;right++){
            sum=sum+nums[right];

            while(sum>=target){
                ans = Math.min(ans,right-left+1);
                sum=sum-nums[left++];                
            }
            
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}