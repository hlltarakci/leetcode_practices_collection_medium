// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    /*
        time: O(log n) -- binary serach twice for left and right limits
        space: O(log n) -- recursion stack
    */
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = binarySearch(nums, target, 0, nums.length-1, true);
        range[1] = range[0] == -1 ? -1 : binarySearch(nums, target, 0, nums.length-1, false);
         
        return range;
    }
    
    private int binarySearch(int[] nums, int target, int min, int max, boolean isLeftLimit) {
        if(min > max) return -1;
        
        int mid = min + (max-min) / 2;
        
        if(nums[mid] == target) {
           if ((isLeftLimit && (mid == 0 || nums[mid-1] != target)) ||
               (!isLeftLimit && (mid == nums.length - 1 || nums[mid+1] != target)) )
               return mid;
           else if (isLeftLimit)
               return binarySearch(nums, target, min, mid-1, isLeftLimit);
           else
               return binarySearch(nums, target, mid+1, max, isLeftLimit);
        } else if(nums[mid] < target) {
            return binarySearch(nums, target, mid+1, max, isLeftLimit);
        } else {
            return binarySearch(nums, target, min, mid-1, isLeftLimit);
        }
    
    }
}
