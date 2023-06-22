class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        if(s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(stack.size() > 0 && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() > 0 ? false : true;
        
    }
}
