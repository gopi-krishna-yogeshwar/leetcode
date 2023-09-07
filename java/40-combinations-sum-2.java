class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        int index = 0;
        Arrays.sort(candidates);
        recursive(result, index, target, currList, candidates);
        return new ArrayList(result);
    }

    public void recursive(List<List<Integer>> result, int index, int target, List<Integer> currList, int[] candidates) {
        
        if(target == 0) {
            result.add(new ArrayList(currList));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            
            currList.add(candidates[index]);
            int currValue = candidates[index];  
            recursive(result, index+1, target - currValue, currList, candidates);
            currList.remove(currList.size()-1);
            while(index < candidates.length && candidates[index] == currValue) {
                index+=1;
            }
            recursive(result, index, target, currList, candidates);
        }
    }
}
