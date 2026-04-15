class Solution {
    public boolean isValid(String s) {
        // traverse(left->right)
        // create open brackets pool
        // compare the close bracket with the first open bracket
        int n = s.length();
        if(n%2 != 0){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.addLast(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char topMost = stack.removeLast();
                if((ch==')' && topMost !='(') || (ch=='}' && topMost !='{') || (ch==']' && topMost !='[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}