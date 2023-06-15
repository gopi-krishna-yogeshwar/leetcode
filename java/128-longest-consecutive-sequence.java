class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longRun = 1;
        int currentRun = 1;
        for(Integer i: set) {
            if(!set.contains(i-1)) {
                int temp = i;
                while(set.contains(temp+1)) {
                    temp += 1;
                }
                longRun = Math.max(longRun, temp-i+1);
            }
        }

        return longRun;
    }
}
