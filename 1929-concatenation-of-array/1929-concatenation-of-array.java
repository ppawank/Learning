class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int j=0;
        int[] arr=new int[length*2];
        for(int i=0;i<arr.length;i++){            
            if(j==(length)){
                j=0;
            }
            arr[i]=nums[j];
            j++;
        }
        return arr;
        
    }
}