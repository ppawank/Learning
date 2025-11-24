class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open=0,close=0;
        String temp="";
        helper(ans,open,close,n,temp);

        return ans;
               
    }

    void helper(List<String> ans,int o,int c,int n,String temp){
        if(o==c && temp.length()==n*2){
            ans.add(temp);
            return;
        }
        //Add open bracket
        if(o<n){
            helper(ans,o+1,c,n,temp+"(");
        }
        //Add close bracket
        if(o>c){
            helper(ans,o,c+1,n,temp+")");
        }
    }
}