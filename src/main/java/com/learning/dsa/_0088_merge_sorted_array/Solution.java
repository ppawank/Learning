package com.learning.dsa._0088_merge_sorted_array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] acopy=new int[m];
       System.arraycopy(nums1, 0, acopy, 0, m);
       int i=0, j=0, k=0;
       while(i<m && j<n) {
            if(acopy[i]<=nums2[j]) {
                nums1[k++]=acopy[i++];
            } else {
                nums1[k++]=nums2[j++];
            }
       }
       while(i<m) { nums1[k++]=acopy[i++]; }
       while(j<n) { nums1[k++]=nums2[j++]; }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0}; int m = 3;
        int[] nums2 = {2,5,6}; int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.print("Merged: [");
        for (int i=0;i<nums1.length;i++) {
            System.out.print(nums1[i]);
            if(i<nums1.length-1) System.out.print(",");
        }
        System.out.println("]");
    }
}