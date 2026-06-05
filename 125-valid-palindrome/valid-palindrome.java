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
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(alpNum.contains(ch)){
                if(ch>='A' && ch<='Z'){
                    ch = (char) (ch - 'A' + 'a');
                }
                sb.append(ch);
            }
        }
        return checkPalindrome(sb.toString());
    }
    public boolean checkPalindrome(String str){
        int l=0;
        int r=str.length()-1;
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