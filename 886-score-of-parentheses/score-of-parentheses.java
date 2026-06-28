class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> dqC = new ArrayDeque<>();
        int curr=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                dqC.addLast(curr);
                curr=0;
            }
            else if(ch==')'){
                curr = dqC.removeLast() + Math.max(curr*2, 1);
            }
        }
        return curr;
    }
}