class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = 1;
        int min = 1;
        int result = nums[0];
        for(int num : nums) {
            int tmp = max * num;
            max = Math.max(num, Math.max(tmp, min * num));
            min = Math.min(num, Math.min(tmp, min * num));
            result = Math.max(result, max);
        }
        return result;
    }
}
