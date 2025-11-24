class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length = word1.length()>word2.length()?word1.length():word2.length();

        int left=0,right=0;
        StringBuilder s=new StringBuilder("");



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
}