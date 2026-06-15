class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1;
        while(i>=0 || j>=0){
            int count = 0;
            while(i>=0 && (s.charAt(i)=='#' || count>0)){
                if(s.charAt(i)=='#'){
                    count++;
                }
                else{
                    count--;
                }
                i--;
            }
            count=0;
            while(j>=0 && (t.charAt(j)=='#' || count>0)){
                if(t.charAt(j)=='#'){
                    count++;
                }
                else{
                    count--;
                }
                j--;
            }
            if(i>=0 && j>=0 && s.charAt(i)==t.charAt(j)){
                i--;
                j--;
            }
            else{
                break;
            }            
        }
        return i==-1&&j==-1;
    }
}