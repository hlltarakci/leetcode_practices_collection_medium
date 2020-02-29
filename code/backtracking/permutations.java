// https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], resultList);
        return resultList;
    }
    
    private void backtrack(
        int[] nums,
        List<Integer> partial,
        boolean[] isUsed,
        List<List<Integer>> resultList) {
        
        if(partial.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(partial));
            return;
        }
        
        for(int i=0; i < nums.length; i++ ) {
            if(isUsed[i]) continue;
            
            isUsed[i] = true;
            partial.add(nums[i]);
            backtrack(nums, partial, isUsed, resultList);
            
            isUsed[i] = false;
            partial.remove(partial.size()-1);
        }
    }
}
