// https://leetcode.com/problems/word-search/

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word.isEmpty()) 
            return false;
        for(int r=0; r < board.length; r++) {
            for(int c=0; c < board[0].length; c++) {
                if( backtrack(board, word, new StringBuilder(), 
                                 new boolean[board.length][board[0].length],
                                 0, r, c))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean backtrack(
        char[][] board,
        String word,
        StringBuilder partial,
        boolean[][] isUsed,
        int index,
        int r,
        int c) {
        if(partial.length() == word.length()) 
            return true;
        
        if(index == word.length() ||
            r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length )
            return false;
        
        char ch = word.charAt(index);
        if(board[r][c] == ch && !isUsed[r][c]) {
            partial.append(ch);
            isUsed[r][c] = true;
            if( 
                backtrack(board, word, partial, isUsed, index+1, r + 1, c) ||
                backtrack(board, word, partial, isUsed, index+1, r - 1, c) ||
                backtrack(board, word, partial, isUsed, index+1, r, c + 1) ||
                backtrack(board, word, partial, isUsed, index+1, r, c - 1) ) 
                return true;
            partial.deleteCharAt(partial.length()-1);
            isUsed[r][c] = false;
        } 
        
        return false;
    }
}
