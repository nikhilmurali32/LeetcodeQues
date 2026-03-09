class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(String c:tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                if(c.equals("/")){
                    int b=Integer.valueOf(st.pop());
                    int a=Integer.valueOf(st.pop());
                    a=a/b;
                    st.push(String.valueOf(a));
                } 
                else if(c.equals("+")){
                    st.push(String.valueOf(Integer.valueOf(st.pop())+ Integer.valueOf(st.pop())));
                }
                else if(c.equals("-")){
                    st.push(String.valueOf(-1*Integer.valueOf(st.pop())+ Integer.valueOf(st.pop())));
                }
                else{
                    st.push(String.valueOf(Integer.valueOf(st.pop())* Integer.valueOf(st.pop())));
                }               
                
            }
            else{
                st.push(c);
            }            
        }
        return Integer.valueOf(st.pop());
    }
}