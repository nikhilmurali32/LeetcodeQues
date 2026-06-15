class Solution {
    public int myAtoi(String s) {
        boolean positive=true;
        long currNum=0;
        boolean digitSeen=false, signSeen=false;
        for(char ch:s.toCharArray()){
            if(currNum>Integer.MAX_VALUE){
                break;
            }
            if(ch==' '){
                if(digitSeen || signSeen){
                    break;
                }
                continue;
            }
            else if(ch=='-' || ch=='+'){
                if(digitSeen || (!digitSeen && signSeen)){
                    break;
                }
                signSeen=true;
                if(ch=='-'){
                    positive=false;
                }
            }
            else if(Character.isDigit(ch)){
                digitSeen=true;
                if(currNum==0 && ch=='0'){
                    continue;
                }
                currNum = currNum*10 + (ch-'0');
            }
            else{
                break;
            }
        }
        if(!positive){
            currNum = Math.max(currNum*-1, Integer.MIN_VALUE);
            return (int)currNum;
        }
        return (int)Math.min(currNum, Integer.MAX_VALUE);
    }
}