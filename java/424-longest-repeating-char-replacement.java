class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        int maxFrequency = 1;
        int result = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(charCount.containsKey(c)) {
                int count = charCount.get(c) + 1;
                maxFrequency = Math.max(count, maxFrequency);
                charCount.put(c, count);
            } else {
                charCount.put(c, 1);
                maxFrequency = Math.max(1, maxFrequency);
            }
            if((right - left +1 - maxFrequency) <= k) {
                result = Math.max(result, right-left+1);
                right += 1;
            } else {
                int newCount = charCount.get(s.charAt(left));
                charCount.put(s.charAt(left), newCount-1);
                left+=1;
                right +=1;
            }
        }
        return result;
    }
}
