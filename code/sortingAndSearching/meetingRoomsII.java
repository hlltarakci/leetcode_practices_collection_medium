// https://leetcode.com/problems/meeting-rooms-ii/

class Solution {
    /*
        time: O(n)
        space: O(n) -- worst case, each meeting needs  a separate room
    */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int[] interval: intervals) {
            if(queue.isEmpty()) queue.add(interval[1]);
            else {
                if(queue.peek() <= interval[0])
                    queue.remove();
                
                queue.add(interval[1]);
            }
        }
        
        return queue.size();
    }
}
