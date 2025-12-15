package com.learning.dsa._0046_permutations;

import java.util.ArrayList;
import java.util.List;

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
            if(paths.contains(nums[i])) continue;
            paths.add(nums[i]);
            helper(ans,nums,paths);
            paths.remove(paths.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
        System.out.println("count=" + res.size());
    }
}
