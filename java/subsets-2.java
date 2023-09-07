class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        int index = 0;
        Arrays.sort(nums);
        recursive(resultSet, index, currList, nums);
        return new ArrayList(resultSet);
    }

    public void recursive(List<List<Integer>> resultSet, int index, List<Integer> currList, int[] nums) {
        if(index >= nums.length) {
            resultSet.add(new ArrayList(currList));
        } else {
            currList.add(nums[index]);
            recursive(resultSet, index+1, currList, nums);
            currList.remove(currList.size()-1);
            int currValue = nums[index];
            while(index < nums.length && currValue == nums[index]) {
                index+=1;
            }
            recursive(resultSet, index, currList, nums);
        }
    }
}
