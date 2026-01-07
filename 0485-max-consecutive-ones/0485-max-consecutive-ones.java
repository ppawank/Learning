class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0,ans=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]==1){
                j++;
                ans=Math.max(ans,j);
            }
            else{
                j=0;
            }
        }
        return ans;
    }
}