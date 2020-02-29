// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    /*
        n: num of digits that map to 3 letters
        m: num of digits that map to 4 letters
        time: O(3^n  + 4^m)
        space: O(3^n  + 4^m) -- output
    */
    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        
        if(digits.isEmpty()) return resultList;
        
        Map<Character, String> map = prepCharsForDigitMap();
        letterCombinations(map, digits, 0,  new StringBuilder(), resultList);
        return resultList;
    }
    
    private void letterCombinations(
        Map<Character, String> map, 
        String digits, 
        int start, 
        StringBuilder partial, 
        List<String> resultList) {
        
        if(start == digits.length()) {
            if(partial.length() == digits.length()) resultList.add(partial.toString());
            return;
        }
        
        for(int i = start; i < digits.length(); i++) {
            String chars = map.get(digits.charAt(i));
            
            for(char ch: chars.toCharArray()) {
                partial.append(ch);
                letterCombinations(map, digits, i+1, partial, resultList);
                partial.deleteCharAt(partial.length()-1);
            }
        }
    }
    
    private Map<Character, String> prepCharsForDigitMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        return map;
    }
}
