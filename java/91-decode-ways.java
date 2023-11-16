class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() +1];
        dp[s.length()] = 1;
        for(int i = s.length()-1; i >-1; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] += dp[i+1];
            }

            if(i+2 <= s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) >= 0 && s.charAt(i+1) <= '6'))) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
