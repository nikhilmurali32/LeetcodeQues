class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new ArrayDeque<>();
        for(String c:tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                if(c.equals("+")){
                    st.push(String.valueOf(Integer.valueOf(st.pop())+ Integer.valueOf(st.pop())));
                }
                else if(c.equals("-")){
                    st.push(String.valueOf(-1*Integer.valueOf(st.pop())+ Integer.valueOf(st.pop())));
                }
                else if(c.equals("*")){
                    st.push(String.valueOf(Integer.valueOf(st.pop())* Integer.valueOf(st.pop())));
                }
                else{
                    int b=Integer.valueOf(st.pop());
                    int a=Integer.valueOf(st.pop());
                    a=a/b;
                    st.push(String.valueOf(a));
                }                
                
            }
            else{
                st.push(c);
            }            
        }
        return Integer.valueOf(st.pop());
    }
}