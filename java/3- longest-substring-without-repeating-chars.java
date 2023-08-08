class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        boolean flag = false;
        if(s.length() == 1) {
            return 1;
        }
        while(left < s.length()) {
            
            map.put(s.charAt(left), left);
            int newIndex = 0;
            for(int i = left+1; i < s.length(); i++) {
                if(map.containsKey(s.charAt(i))) {
                    newIndex = map.get(s.charAt(i)) + 1;
                    map.clear();
                    result = Math.max(result, i-left);
                    break;
                } else {
                    map.put(s.charAt(i), i);
                }
                result = Math.max(result, i-left+1);
            }
            if(newIndex == 0) {
                break;
            } else {
                left = newIndex;
            }

        }
        return result;
    }
}
