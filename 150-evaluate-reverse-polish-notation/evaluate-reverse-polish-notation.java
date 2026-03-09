class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String c:tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                if(c.equals("/")){
                    int b=st.pop();
                    int a=st.pop();
                    a=a/b;
                    st.push(a);
                } 
                else if(c.equals("+")){
                    st.push(st.pop()+ st.pop());
                }
                else if(c.equals("-")){
                    st.push(-1*st.pop()+ st.pop());
                }
                else{
                    st.push(st.pop()* st.pop());
                }               
                
            }
            else{
                st.push(Integer.valueOf(c));
            }            
        }
        return st.pop();
    }
}