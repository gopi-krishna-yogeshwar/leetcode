class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for(Integer i : nums) {
            countMap.put(i, countMap.getOrDefault(i,0) +1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> countMap.get(a) - countMap.get(b));
        for(Integer i : countMap.keySet()) {
            pq.add(i);
            if(pq.size() > k) {
                pq.poll();
            }
        } 

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        } 
        return result;
    }
}
