class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    public boolean helper(String s, String p, int i, int j){
        int n1=s.length();
        int n2=p.length();
        if(i>=n1 && j>=n2){
            return true;
        }
        if(j>=n2){
            return false;
        }
        boolean match = i<n1 && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if((j+1)<n2 && p.charAt(j+1)=='*'){
            return helper(s,p,i,j+2) || (match && helper(s,p,i+1, j));
        }
        if(match){
            return helper(s,p,i+1,j+1);
        }
        return false;
    }
}