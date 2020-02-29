// https://leetcode.com/problems/jump-game/

class Solution {
    /*
        time: O(n^2)
        space: O(n) -- dp table
    */
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++ ) {
            if(!dp[i]) continue;
            
            for(int jumpForward=1; jumpForward <= nums[i]; jumpForward++) {
                if( (i+jumpForward) < nums.length)dp[i+jumpForward] = true;
            }
        }
        
        return dp[nums.length-1];
    }
}
