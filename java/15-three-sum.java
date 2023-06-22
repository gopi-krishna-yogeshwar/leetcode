class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int target = 0 - nums[i];
                int left = i+1;
                int right = nums.length-1;
                while(left < right) {
                    if(nums[left] + nums[right] == target) {
                        List<Integer> s = new ArrayList<Integer>();
                        s.add(nums[i]);
                        s.add(nums[left]);
                        s.add(nums[right]);
                        result.add(s);
                        while(left < right && nums[left] == nums[left+1]) {
                            left += 1;
                        }
                        while(left < right && nums[right] == nums[right-1]) {
                            right -= 1;     
                        }
                        left +=1;
                        right -=1;
                    } else if(nums[left] + nums[right] < target) {
                        left += 1;
                    } else {
                        right -=1;
                    }
                }
            }
            
        }
        return result;
        
    }
}
