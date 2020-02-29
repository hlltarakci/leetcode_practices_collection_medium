// https://leetcode.com/problems/unique-paths/

class Solution {
    /*
        time: O(mn)
        space: O(mn) -- dp table
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        
        for(int col = 1; col < n; col++) dp[0][col] = 1;
        for(int row = 1; row < m; row++) dp[row][0] = 1;
        
        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                if(dp[row][col] > 0) continue;
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        
        
        return dp[m-1][n-1];
    }
}
