class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if((prices[i] - minPrice) > result) {
                result = prices[i] - minPrice;
            }
        }
        return result;
    }
}
