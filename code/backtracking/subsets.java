// https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), resultList);
        return resultList;
    }
    
    private void backtrack(
        int[] nums,
        int index,
        List<Integer> partial,
        List<List<Integer>> resultList ) {
        if(index == nums.length) {
            resultList.add(new ArrayList<Integer>(partial));
            return;
        }
        
        partial.add(nums[index]);
        backtrack(nums, index+1, partial, resultList);

        partial.remove(partial.size()-1);
        backtrack(nums, index+1, partial, resultList);
    }
}
