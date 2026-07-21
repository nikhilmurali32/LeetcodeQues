class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n=len(nums)
        prod=[1]*n
        for i in range(n):
            if i==0:
                continue
            prod[i] = prod[i-1]*nums[i-1]
        prev=1
        for i in range(n-1, -1, -1):
            if i==n-1:
                continue
            prev *= nums[i+1]
            prod[i] *= prev
        return prod