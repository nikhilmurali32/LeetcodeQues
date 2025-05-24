class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int cur=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(cur);
                cur=0;
            }
            else{
                cur = st.pop() + Math.max(2*cur, 1);
            }
        }
        return cur;
    }
}