class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(String c:tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int b=Integer.valueOf(st.pop());
                int a=Integer.valueOf(st.pop());
                if(c.equals("+")){
                    a=a+b;
                }
                else if(c.equals("-")){
                    a=a-b;
                }
                else if(c.equals("*")){
                    a=a*b;
                }
                else{
                    // if(a<0 || b<0){
                    //     a=0;
                    // }
                    // else{
                        a=a/b;
                    // }
                }
                
                st.push(String.valueOf(a));
            }
            else{
                st.push(c);
            }            
        }
        return Integer.valueOf(st.pop());
    }
}