class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(nums,0,ans,new ArrayList<Integer>());
        
        return ans;
    }

    void helper(int[] nums,int start,List<List<Integer>> ans,List<Integer> paths){
        ans.add(new ArrayList<>(paths));

        for(int i=start;i<nums.length;i++){
            paths.add(nums[i]);
            helper(nums,i+1,ans,paths);
            paths.remove(paths.size()-1);
        }
    }
}