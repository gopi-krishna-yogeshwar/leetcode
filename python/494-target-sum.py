class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}
        def dfs(index, target):
            if index == len(nums) and target != 0:
                return 0
            if index == len(nums) and target == 0:
                return 1
                
            if (index,target) in dp:
                return dp[(index,target)]
            
            ways = dfs(index+1, target-nums[index]) + dfs(index+1, target+nums[index])
            dp[(index, target)] = ways
            return ways
        
        return dfs(0,target)
        
