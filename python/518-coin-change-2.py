class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = {}
        def dfs(index, amount):
            if amount == 0:
                return 1
            if amount < 0 or index >= len(coins):
                return 0
            if (index,amount) in dp:
                return dp[(index,amount)]
            
            res = dfs(index+1, amount) + dfs(index, amount-coins[index])
            dp[(index,amount)] = res
            return res

        return dfs(0, amount)

        
