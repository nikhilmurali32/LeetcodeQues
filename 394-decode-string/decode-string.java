class Solution {
    public String decodeString(String s) {
        Deque<Integer> digits = new ArrayDeque<>();
        Deque<StringBuilder> letters = new ArrayDeque<>();
        int currNum=0;
        StringBuilder currStr = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum = currNum*10 + (ch-'0');
            }
            else if(ch=='['){
                digits.addLast(currNum);
                letters.addLast(currStr);
                currNum=0;
                currStr=new StringBuilder();
            }
            else if(ch==']'){
                int multiplier = digits.removeLast();
                StringBuilder str = letters.removeLast();
                for(int i=0; i<multiplier; i++){
                    str.append(currStr);
                }
                currStr = str;
            }
            else{
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}