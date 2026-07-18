class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        seen = set()
        for i, num in enumerate(nums):
            if target-num in seen:
                return [i, map[target-num]]
            seen.add(num)
            map[num] = i
        return [-1,-1]
