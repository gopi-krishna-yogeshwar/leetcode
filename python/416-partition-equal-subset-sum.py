class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total_sum = sum(nums)
        if total_sum % 2 == 1:
            return False
        half = total_sum // 2
        sum_set = set()
        sum_set.add(0)
        sum_set.add(nums[-1])
        
        for i in range(len(nums)-2, -1, -1):
            tmp_set = set()
            for num in sum_set:
                tmp_set.add(num + nums[i])
            tmp_set.add(nums[i])
            sum_set = sum_set.union(tmp_set)

            if half in sum_set:
                return True

        return False
