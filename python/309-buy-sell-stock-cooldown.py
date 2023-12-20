class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}

        def dfs(index, buying):
            if index >= len(prices):
                return 0
            if (index, buying) in dp:
                return dp[(index, buying)]
            c = dfs(index+1, buying)
            if buying:
                b = dfs(index+1, not buying) - prices[index]
                
                dp[(index, buying)] = max(b,c)
            else:
                s = dfs(index+2, not buying) + prices[index]
                dp[(index, buying)] = max(s,c)

            return dp[(index, buying)]
        return dfs(0, True)

        
