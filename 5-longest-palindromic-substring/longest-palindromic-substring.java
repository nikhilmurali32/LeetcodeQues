class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int start=0, end=0;
        for(int i=0; i<s.length(); i++){
            int odd = helper(s, i, i);
            int even = helper(s, i, i+1);
            int max = Math.max(odd, even);
            if(max>end-start){
                start = i-(max-1)/2;
                end = i+(max)/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int helper(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}