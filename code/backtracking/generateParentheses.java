// https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        backtrack(n, 0, new StringBuilder(), resultList);
        return resultList;
    }
    
    private void backtrack(
        int n, 
        int unmatchedOpenParCount, 
        StringBuilder partial, 
        List<String> resultList) {
        if(partial.length() == 2 * n) {
            if(unmatchedOpenParCount == 0) resultList.add(partial.toString());
            return; 
        }
        
        if( unmatchedOpenParCount < n ) {
            partial.append("(");
            backtrack(n, unmatchedOpenParCount+1, partial, resultList);
            partial.deleteCharAt(partial.length()-1);
        }

        if( unmatchedOpenParCount > 0) {
            partial.append(")");
            backtrack(n, unmatchedOpenParCount-1, partial, resultList);
            partial.deleteCharAt(partial.length()-1);
        }
        
    } 
} 
