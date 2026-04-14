class Solution {
    public boolean isPalindrome(String s) {
        Character[] lowerCase = new Character[26];
        for(int i=0; i<26; i++){
            lowerCase[i] = (char)('a'+i);
        }
        return checkPalindrome(s, lowerCase);
    }
    public boolean checkPalindrome(String str, Character[] lowerCase){
        int l=0, r=str.length()-1;
        while(l<r){
            char chLeft = str.charAt(l);
            char chRight = str.charAt(r);
            if(!(chLeft>='a' && chLeft<='z') && !(chLeft>='0' && chLeft<='9') && !(chLeft>='A' && chLeft<='Z')){
                l++;
                continue;
            }
            if(!(chRight>='a' && chRight<='z') && !(chRight>='0' && chRight<='9') && !(chRight>='A' && chRight<='Z')){
                r--;
                continue;
            }
            if(chLeft>='A' && chLeft<='Z'){
                chLeft = lowerCase[chLeft-'A'];
            }
            if(chRight>='A' && chRight<='Z'){
                chRight = lowerCase[chRight-'A'];
            } 
            if(chLeft != chRight){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}