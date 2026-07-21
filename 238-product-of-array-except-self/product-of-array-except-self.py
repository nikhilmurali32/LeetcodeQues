class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n=len(nums)
        prod=[1]*n
        prev=nums[0]
        for i, num in enumerate(nums):
            if i==0:
                continue
            prod[i] = prod[i-1]*prev
            prev=num
        suff=1
        for i in range(n-1, -1, -1):
            if i==n-1:
                continue
            suff *= nums[i+1]
            prod[i] *= suff
        return prod