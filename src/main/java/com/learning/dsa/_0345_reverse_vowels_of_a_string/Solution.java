package com.learning.dsa._0345_reverse_vowels_of_a_string;

class Solution {
    public String reverseVowels(String s) {
        char[] chArray = s.toCharArray();
        int i=0,j=s.length()-1;

        while(i<j){
            if(!isVowelChar(chArray[i])){
                i++;
                continue;
            }
            if(!isVowelChar(chArray[j])){
                j--;
                continue;
            }
            char temp=chArray[i];
            chArray[i]=chArray[j];
            chArray[j]=temp;
            i++;
            j--;
        }

        return String.valueOf(chArray);
    }

    private boolean isVowelChar(char c){
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello")); // holle
        System.out.println(solution.reverseVowels("leetcode")); // leotcede
        System.out.println(solution.reverseVowels("aA")); // Aa
    }
}