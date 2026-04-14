class Solution {
    public boolean isPalindrome(String s) {
        Character[] lowerCase = new Character[26];
        for(int i=0; i<26; i++){
            lowerCase[i] = (char)('a'+i);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='A' && ch<='Z'){
                sb.append(lowerCase[ch-'A']);
            }
            else if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                sb.append(ch);
            }        
        }
        String finalString = sb.toString();
        if(finalString.length()==0){
            return true;
        }
        return checkPalindrome(finalString);
    }
    public boolean checkPalindrome(String str){
        int l=0, r=str.length()-1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}