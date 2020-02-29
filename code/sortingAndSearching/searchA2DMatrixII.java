// https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
    /*
        time: O(c log r)
        space: O(log r) -- recursion stack
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        
        for(int col=0; col < matrix[0].length; col++) {
            if(matrix[0][col] > target) continue;
            if( binarySearch(matrix, col, target, 0, matrix.length-1) >= 0) 
                return true;
        }
        
        return false;
    }
    
    private int binarySearch(int[][] matrix, int col, int target, int min, int max) {
        if(min > max) return -1;
        
        int mid = min + (max-min)/2;
        if(matrix[mid][col] == target) return mid;
        else if(matrix[mid][col] < target) return binarySearch(matrix, col, target, mid+1, max);
        else return binarySearch(matrix, col, target, min, mid-1);
        
    }
}
