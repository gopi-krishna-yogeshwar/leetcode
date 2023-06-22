class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        Set<String>  operators = new HashSet<String>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(String str: tokens) {
            if(operators.contains(str)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(str) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
