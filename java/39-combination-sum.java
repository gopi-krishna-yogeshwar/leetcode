class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        recursive(result, currList, candidates, target, 0);
        return result;
    }

    public void recursive(List<List<Integer>> result, List<Integer> currList, int[] candidates, int target, int index) {
        //System.out.println(target);
        if(target == 0) {
            result.add(new ArrayList<>(currList));
        }
        else if (target < 0 || index >= candidates.length){
            return;
        } else {
            currList.add(candidates[index]);
            recursive(result, currList, candidates, target-candidates[index], index);
            currList.remove(currList.size()-1);
            recursive(result, currList, candidates, target, index+1);
        }
      
    }
}
