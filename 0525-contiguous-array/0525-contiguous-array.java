class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0;
        int len=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum=sum-1;
            }else{
                sum=sum+1;
            }
            if(sum==0){
                len=i+1;
            }
            if(map.containsKey(sum)){
                len=Math.max(len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return len;
    }
}