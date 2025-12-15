package com.learning.dsa._0078_subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(nums,0,ans,new ArrayList<>());

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println("Subsets of [1,2,3]:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        System.out.println("Total: " + result.size());
    }
}
