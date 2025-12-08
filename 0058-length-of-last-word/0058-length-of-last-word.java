class Solution {
    public int lengthOfLastWord(String s) {
        String[] wordsBySpace = s.split(" ");
        return wordsBySpace[wordsBySpace.length-1].length();
    }
}