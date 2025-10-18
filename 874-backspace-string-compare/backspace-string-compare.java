class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1, count;
        while(true){
            count=0;
            while(i>=0 && (count>0 || s.charAt(i)=='#')){
                if(s.charAt(i)=='#'){
                    count++;
                }
                else{
                    count--;
                }
                i--;
            }
            count=0;
            while(j>=0 && (count>0 || t.charAt(j)=='#')){
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
        return i==-1 && j==-1;
    }
}