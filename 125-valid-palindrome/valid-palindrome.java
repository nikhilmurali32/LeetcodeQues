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
        int l=0;
        int r=s.length()-1;
        while(l<r){
            while(l<s.length() && l<r && !alpNum.contains(s.charAt(l))){
                l++;
            }
            if(l==s.length() || l>=r){
                break;
            }
            char ch_l = s.charAt(l);
            if(ch_l>='A' && ch_l<='Z'){
                ch_l = (char) (ch_l - 'A' + 'a');
            }

            while(r>=0 && l<r && !alpNum.contains(s.charAt(r))){
                r--;
            }
            if(r<0 || l>=r){
                break;
            }
            char ch_r = s.charAt(r);
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