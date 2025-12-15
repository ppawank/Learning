package com.learning.dsa._0009_palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tests = {121, -121, 10, 12321, 0};
        for (int t : tests) {
            System.out.println("isPalindrome(" + t + ") = " + solution.isPalindrome(t));
        }
    }
}
