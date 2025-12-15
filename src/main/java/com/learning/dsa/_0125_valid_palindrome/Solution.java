package com.learning.dsa._0125_valid_palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        String str = String.valueOf(cleanString(s));
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }
    public String cleanString(String x) {
        char[] charArray = x.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('a' + c - 'A'));
            }else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tests = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "0P",
            "No 'x' in Nixon"
        };
        for (String s : tests) {
            System.out.println("isPalindrome(\"" + s + "\") = " + solution.isPalindrome(s));
        }
    }
}