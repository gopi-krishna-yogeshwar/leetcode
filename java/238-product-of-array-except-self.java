class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        int prev = 1;
        for(int i = 0; i < nums.length; i++) {
            forward[i] = prev * nums[i];
            prev = forward[i];
        }
        prev =1;
        for(int i = nums.length-1; i > -1; i--) {
            backward[i] = prev * nums[i];
            prev = backward[i];
        }     

        int[] result = new int[nums.length];
        for(int i = 0; i<nums.length;i++) {
            if(i == 0) {
                result[i] = backward[i+1];
            } else if(i == nums.length-1) {
                result[i] = forward[i-1];
            } else {
                result[i] = forward[i-1] * backward[i+1];
            }
        }

        return result;
    }
}
