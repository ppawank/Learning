package com.learning.dsa._1929_concatenation_of_array;

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

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 1};
        int[] result1 = solution.getConcatenation(nums1);
        System.out.print("Input: [1,2,1] -> Output: [");
        for(int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if(i < result1.length - 1) System.out.print(",");
        }
        System.out.println("]");

        // Test case 2
        int[] nums2 = {1, 3, 2, 1};
        int[] result2 = solution.getConcatenation(nums2);
        System.out.print("Input: [1,3,2,1] -> Output: [");
        for(int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if(i < result2.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}