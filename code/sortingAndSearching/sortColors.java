// https://leetcode.com/problems/sort-colors/

class Solution {
    /*
        time: O(n)
        space: O(1)
    */
    public void sortColors(int[] nums) {
        int zeroIndex = -1, twoIndex = nums.length;
        for(int i=0; i < nums.length; i++) {
            if(i >= twoIndex) break;
            
            if(nums[i] == 0) {
                swap(nums, ++zeroIndex, i);
            } else if(nums[i] == 2) {
                swap(nums, --twoIndex, i);
                i--;
            } 
            
        }
    }
    
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
