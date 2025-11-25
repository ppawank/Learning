class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int low=0,high=height.length-1;

        while(low<high){
            final int minHeight = Math.min(height[low],height[high]);
            ans = Math.max( ans, minHeight * ( high - low) );
            if(height[low]<height[high]){
                ++low;
            }else{
                --high;
            }
            
        }
        return ans;
    }
}