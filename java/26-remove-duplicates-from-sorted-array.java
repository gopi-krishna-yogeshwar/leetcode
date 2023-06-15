class Solution {
    public int removeDuplicates(int[] nums) {
        int start = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == start) {
                nums[i] = 101;
            } else {
                start = nums[i];
                nums[count] = start;
                count += 1;
            }
        }

        return count;
    }
}
