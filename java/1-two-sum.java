class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];


        for(int i = 0; i < nums.length; i++) {
            int diff = target-nums[i];
            if(map.containsKey(diff)) {
                result[0] = i;
                result[1] = map.get(diff);
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
