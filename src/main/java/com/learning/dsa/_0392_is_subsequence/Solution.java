package com.learning.dsa._0392_is_subsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc","ahbgdc")); // true
        System.out.println(solution.isSubsequence("axc","ahbgdc")); // false
    }
}