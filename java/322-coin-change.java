class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        for(int i = 1; i < amount+1; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i < coins[j]) {
                    continue;
                } else if(minCoins[i-coins[j]] != -1){
                    min = Math.min(min, 1 + minCoins[i-coins[j]]);
                }
            }
            minCoins[i] = min == Integer.MAX_VALUE ? -1 : min;

        }
        return minCoins[amount];
    }
}
