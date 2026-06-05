class Solution {
    public boolean isPalindrome(String s) {
        HashSet<Character> alpNum = new HashSet<>();
        for(char c='a'; c<='z'; c++){
            alpNum.add(c);
        }
        for(char c='A'; c<='Z'; c++){
            alpNum.add(c);
        }
        for(char c='0'; c<='9'; c++){
            alpNum.add(c);
        }
        return checkPalindrome(s, alpNum);
    }
    public boolean checkPalindrome(String str, HashSet<Character> alpNum){
        int l=0;
        int r=str.length()-1;
        while(l<r){
            while(l<str.length() && l<r && !alpNum.contains(str.charAt(l))){
                l++;
            }
            if(l==str.length() || l>=r){
                break;
            }
            char ch_l = str.charAt(l);
            if(ch_l>='A' && ch_l<='Z'){
                ch_l = (char) (ch_l - 'A' + 'a');
            }

            while(r>=0 && l<r && !alpNum.contains(str.charAt(r))){
                r--;
            }
            if(r<0 || l>=r){
                break;
            }
            char ch_r = str.charAt(r);
            if(ch_r>='A' && ch_r<='Z'){
                ch_r = (char) (ch_r - 'A' + 'a');
            }        
            if(ch_l != ch_r){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}