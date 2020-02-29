// https://leetcode.com/problems/merge-intervals/

class Solution {
    /*
        time: O(n log n) -- for sorting, algorithm takes O(n)
        space: O(n) -- output space
    */
    public int[][] merge(int[][] intervals) {
        int[][] mergedIntervals = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int mergedIntervalCount = 0;
        for(int[] interval: intervals) {
            if(mergedIntervalCount == 0) {
                mergedIntervals[mergedIntervalCount++] = interval;
            } else if( mergedIntervals[mergedIntervalCount-1][1] >= interval[0] ) {
                mergedIntervals[mergedIntervalCount-1][1] = 
                    Math.max(mergedIntervals[mergedIntervalCount-1][1], interval[1]);
            } else {
               mergedIntervals[mergedIntervalCount++] = interval; 
            }
        }
        
        
        return Arrays.copyOfRange(mergedIntervals, 0, mergedIntervalCount);
    }
}
