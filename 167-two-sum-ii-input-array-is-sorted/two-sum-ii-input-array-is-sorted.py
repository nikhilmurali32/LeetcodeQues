class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(numbers)):
            if target-numbers[i] in map:
                break
            map[numbers[i]]=i
        return [map[target-numbers[i]]+1, i+1]