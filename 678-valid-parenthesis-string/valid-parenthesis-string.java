class Solution {
    public boolean checkValidString(String s) {
        int openMax=0, openMin=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                openMax++;
                openMin++;
            }
            else if(ch==')'){
                openMax--;
                openMin--;
            }
            else{
                openMax++;
                openMin--;
            }
            if(openMax<0){
                return false;
            }
            if(openMin<0){
                openMin=0;
            }
        }
        return openMin==0;
    }
}