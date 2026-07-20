class Solution {
    /**
     * Removes duplicates from a sorted array in-place and returns the number of unique elements.
     *
     * <p>The first returned-length elements of {@code nums} will contain the unique values in
     * their original sorted order.</p>
     *
     * @param nums the sorted input array
     * @return the count of unique elements
     */
    public int removeDuplicates(int[] nums) {
       int j=0;
       for(int i=1;i<nums.length;i++){
        // When a new value is found, place it next in the unique section.
        if(nums[j]!=nums[i]){
            nums[++j]=nums[i];
        }
       }
       // Convert the last unique index to the total number of unique elements.
       return ++j;
    }
}