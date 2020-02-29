// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    /*
        time: O(n^2)
        space: O(1)
    */
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return "";
        
        int maxLeft=0, maxRight=0;
        for(int i=0; i<s.length(); i++) {
            
            int[] indexes = getBiggerInterval(
                                expandAround(s, i, true), 
                                expandAround(s, i, false));
            
            if( (maxRight - maxLeft) < (indexes[1]-indexes[0])) {
                maxLeft = indexes[0];
                maxRight = indexes[1];
            }
        }
        
        return s.substring(maxLeft, maxRight+1);
    }
    
    private int[] expandAround(String s, int i, boolean isOddCase) {
        int[] indexes = new int[2];
        
        int left = i, right = i;
        if(!isOddCase) left = i-1;
        
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) break;
            else {
                indexes[0] = left--;
                indexes[1] = right++;
            }
        }
        
        return indexes;
    }
    
    private int[] getBiggerInterval(int[] first, int[] second) {
        return (first[1] - first[0]) < (second[1] - second[0]) ? second : first;
    }
               
              
}
