class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.addLast(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if(ch==')'){
                    if(stack.peekLast()!='('){
                        return false;
                    }
                    stack.removeLast();
                }
                else if(ch=='}'){
                    if(stack.peekLast()!='{'){
                        return false;
                    }
                    stack.removeLast();                    
                }
                else{
                    if(stack.peekLast()!='['){
                        return false;
                    }
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }
}