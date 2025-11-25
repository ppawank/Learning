class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(ans,nums,temp);

        return ans;
    }

    void helper(List<List<Integer>> ans,int[] nums,List<Integer> paths){
        if(paths.size()==nums.length){
            ans.add(new ArrayList<>(paths));
        }

        for(int i=0;i<nums.length;i++){
            if(paths.contains(nums[i]))
            continue;

            paths.add(nums[i]);
            helper(ans,nums,paths);
            paths.remove(paths.size()-1);   
        }

    }
}