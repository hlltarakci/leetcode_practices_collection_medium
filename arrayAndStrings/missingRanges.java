// https://leetcode.com/problems/missing-ranges/

class Solution {
    /*
        time: O(n)
        space: O(1) -- excluding output
    */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            ranges.add(missing(nums, lower, upper));
            return ranges;
        } 
        
        long lowerL = (long) lower;
        for(int num: nums) {
            if( lowerL < num ) ranges.add(missing(nums, lowerL, (long) num - 1));
            lowerL = (long) num + 1;
        }
        
        if(upper > nums[nums.length-1]) ranges.add(missing(nums, (long) nums[nums.length-1] + 1, (long) upper));
        
        return ranges;
    }
    
    private String missing(int[] nums, long lower, long upper) {
        StringBuilder sb = new StringBuilder();
        sb.append(lower);
        if(upper > lower) sb.append("->").append(upper);
        return sb.toString();
    }
}
