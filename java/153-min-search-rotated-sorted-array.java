class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int result = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (left+right) / 2;
            if(nums[left] < nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }
            result = Math.min(nums[mid], result);
            if(nums[left] <= nums[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            } 
        }
        return result;
    
    }
}
