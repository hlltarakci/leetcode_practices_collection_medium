// https://leetcode.com/problems/number-of-islands/

class Solution {
    /*
        time: O(n m)
        space: O( max(n, m)) -- recursion stack
    */
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        
        int count = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    turnNeighboursToWater(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void turnNeighboursToWater(char[][] grid, int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        
        if( grid[i][j] == '1') {
            grid[i][j] = '0';
            turnNeighboursToWater(grid, i - 1, j);
            turnNeighboursToWater(grid, i, j-1);
            turnNeighboursToWater(grid, i + 1, j);
            turnNeighboursToWater(grid, i, j + 1);
        }
    }
}
