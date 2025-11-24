class Solution {
    public String reverseVowels(String s) {
        int left=0,right=s.length()-1;
        StringBuilder sb=new StringBuilder(s);

        while (left < right) {
            while (left < right && !isVowel(sb.charAt(left)))
                ++left;
            while (left < right && !isVowel(sb.charAt(right)))
                --right;
            sb.setCharAt(left, s.charAt(right));
            sb.setCharAt(right, s.charAt(left));
            ++left;
            --right;
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }
}