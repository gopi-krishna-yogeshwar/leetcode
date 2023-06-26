class Solution {
    Stack<String> stack = new Stack<String>();
    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        backTrack(0,0,n);
        return result;
    }

    public void backTrack(int open, int close, int n) {
        if(open == n && close == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            result.add(temp);
        }
        if(open < n) {
            stack.push("(");
            backTrack(open+1, close, n);
            stack.pop();
        }
        if(open > close) {
            stack.push(")");
            backTrack(open, close+1, n);
            stack.pop();
        }
    }
}
