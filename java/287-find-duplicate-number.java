class Solution {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = 0;
        while(left != right || (left == 0 && right == 0)) {
            left = nums[left];
            right = nums[nums[right]];
        }
        int left1 = 0;
        while(left1 != left) {
            left1 = nums[left1];
            left = nums[left];
        }
        return left;
    }
}
