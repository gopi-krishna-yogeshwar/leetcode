class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public static int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();
        for(int num : nums) {
            this.pq.add(num);
        }

        while(this.pq.size() > k) {
            this.pq.poll();
        }

        
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
