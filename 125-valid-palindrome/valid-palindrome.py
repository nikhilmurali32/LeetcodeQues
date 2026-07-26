class Solution:
    def isPalindrome(self, s: str) -> bool:
        finalStr = ""
        for ch in s:
            if (ch>='a' and ch<='z') or (ch>='A' and ch<='Z') or (ch>='0' and ch<='9'):
                finalStr += ch
        res = finalStr.lower()
        return self.isPal(res)
    def isPal(self, res:str) -> bool:
        for i in range((len(res)//2)):
            if res[i] != res[len(res)-i-1]:
                return False
        return True