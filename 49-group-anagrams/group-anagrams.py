class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for str in strs:
            sortedStr = "".join(sorted(str))
            if sortedStr not in map:
                map[sortedStr] = []
            map[sortedStr].append(str)
        res = []
        for key in map:
            res.append(map[key])
        return res
