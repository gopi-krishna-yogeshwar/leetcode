class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<Integer>();
        this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        this.maxHeap.add(num);
        if(this.maxHeap.size() - this.minHeap.size() == 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if(this.minHeap.size() > 0 && this.maxHeap.size() > 0 && this.maxHeap.peek() > this.minHeap.peek()) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if(this.minHeap.size() - this.maxHeap.size() == 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }
    
    public double findMedian() {

        if(this.minHeap.size() == this.maxHeap.size()) {
            return (this.minHeap.peek() + this.maxHeap.peek())/2.0;
        }
        if(this.minHeap.size() > this.maxHeap.size()) {
            return this.minHeap.peek();
        }
        return this.maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
