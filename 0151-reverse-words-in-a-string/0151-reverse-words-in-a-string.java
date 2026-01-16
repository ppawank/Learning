class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        String[] arr= new String[n];
        arr = s.split(" ");

        StringBuilder str = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            String temp=arr[i].trim();
            if(temp.length()>0){
                str.append(temp);
                str.append(" ");
            }
            
        }
        return str.toString().trim();
    }
}