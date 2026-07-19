class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map={}
        for num in nums:
            map[num] = map.get(num, 0)+1
        res = [[] for _ in range(len(nums)+1)]
        for key in map:
            res[map[key]].append(key)
        ans = []
        for i in range(len(res)-1, 0, -1):
            if k<=0:
                break
            ans.extend(res[i])
            k -= len(res[i])
        return ans