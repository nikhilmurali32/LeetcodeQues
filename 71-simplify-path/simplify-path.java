class Solution {
    public String simplifyPath(String path) {
        String[] str_arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(String str:str_arr){
            // System.out.println(str=="..");
            if(str.equals(".")){
                continue;
            }
            else if(str.equals("..")){
                // System.out.println(str);
                int i=2;
                while(!st.isEmpty() && i>0){
                    // System.out.println(st.pop());
                    st.pop();
                    i--;
                }
            }
            else if(str.equals("")){
                continue;
            }
            else{
                st.add("/");
                st.add(str);
            }
        }
        if(st.isEmpty()){
            st.add("/");
        }
        String res="";
        while(!st.isEmpty()){
            res = st.pop()+res;
        }
        return res;
    }
}