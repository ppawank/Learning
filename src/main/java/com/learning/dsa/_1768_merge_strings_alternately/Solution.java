package com.learning.dsa._1768_merge_strings_alternately;
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length = Math.max(word1.length(), word2.length());

        StringBuilder s=new StringBuilder();
        for(int i=0;i<length;i++){
            if(i<word1.length()){
                s.append(word1.charAt(i));
            }
            if(i<word2.length()){
                s.append(word2.charAt(i));
            }                
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String word1a = "abc";
        String word2a = "pqr";
        String result1 = solution.mergeAlternately(word1a, word2a);
        System.out.println("Input: word1 = \"abc\", word2 = \"pqr\" -> Output: \"" + result1 + "\"");

        // Test case 2
        String word1b = "ab";
        String word2b = "pqrs";
        String result2 = solution.mergeAlternately(word1b, word2b);
        System.out.println("Input: word1 = \"ab\", word2 = \"pqrs\" -> Output: \"" + result2 + "\"");

        // Test case 3
        String word1c = "abcd";
        String word2c = "pq";
        String result3 = solution.mergeAlternately(word1c, word2c);
        System.out.println("Input: word1 = \"abcd\", word2 = \"pq\" -> Output: \"" + result3 + "\"");
    }
}