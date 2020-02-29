// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    /*
        time: O(n)
        space: O(m) where m is num of distinct chars in the longest substring -- set usage
    */
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;
        for(char c: s.toCharArray()) {
            while(set.contains(c)) 
                set.remove(s.charAt(left++));
            
            maxLen = Math.max((right-left+1), maxLen);
            
            set.add(c);
            right++;
        }
        
        
        
        return maxLen;
    }
}
