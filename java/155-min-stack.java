class MinStack {
    private Stack<int[]> stack = new Stack<int[]>();
    public MinStack() {
        //return this;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            this.stack.push(new int[]{val,val});
            return;
        }

        int currentMin = this.stack.peek()[1];
        this.stack.push(new int[]{val, Math.min(val, currentMin)});
        

    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek()[0];
    }
    
    public int getMin() {
        return this.stack.peek()[1];
    }
}
