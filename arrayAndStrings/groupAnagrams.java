// https://leetcode.com/problems/group-anagrams/

class Solution {
    /*
        n: num of string
        m: max length of string
        time: O(n m log m)
        space: O(n m) -- map usage
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        populateMap(strs, map);
        
        for(List<String> group: map.values())
            groups.add(group);
        
        return groups;
    }
    
    private void populateMap(String[] strs, HashMap<String, List<String>> map) {
        for(String str: strs) {
            char[] keyArray = str.toCharArray();
            Arrays.sort(keyArray);
            
            String key = String.valueOf(keyArray);
            List<String> group = map.getOrDefault(key, new ArrayList<String>());
            group.add(str);
            map.put(key, group);
        }
    }
}
