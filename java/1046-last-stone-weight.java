class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int stone : stones) {
            pq.add(stone);
        }
        while(pq.size() > 1) {
            int remaining = Math.abs(pq.poll() - pq.poll());
            if(remaining > 0) {
                pq.add(remaining);
            }
        }

        return pq.size() > 0 ? pq.poll() : 0;
         
    }
}
