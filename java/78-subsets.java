class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        int index = 0;
        recursive(result, index, currList, nums);
        return result;
    }

    public void recursive(List<List<Integer>> result, int index, List<Integer> currList, int[] nums) {

        if(index >= nums.length) {
            result.add(new ArrayList<Integer>(currList));
        } else {
            currList.add(nums[index]);
            recursive(result, index+1, currList, nums);
            currList.remove(currList.size()-1);
            recursive(result, index+1, currList, nums);
        }
    }
}
