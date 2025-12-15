package com.learning.dsa._0028_find_index_first_occurrence;

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("sadbutsad", "sad")); // 0
        System.out.println(solution.strStr("leetcode", "leeto")); // -1
        System.out.println(solution.strStr("abc", "")); // 0 per Java indexOf behavior
    }
}
