class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        int tLength=t.length();
        int sLength=s.length();

        while(i<tLength && j<sLength){
            if(t.charAt(i)==s.charAt(j)){
                j++;
            }
            i++;
        }
        return j==sLength;
    }
}