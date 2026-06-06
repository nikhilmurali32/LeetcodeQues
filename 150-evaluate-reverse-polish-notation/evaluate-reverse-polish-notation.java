class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> symbols = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Deque<Integer> numbers = new ArrayDeque<>();
        for(String token:tokens){
            if(!symbols.contains(token)){
                numbers.addLast(Integer.valueOf(token));
            }
            else{
                int second = numbers.removeLast();
                int first = numbers.removeLast();
                if(token.equals("+")){
                    numbers.addLast(first+second);
                }
                else if(token.equals("-")){
                    numbers.addLast(first-second);
                }
                else if(token.equals("*")){
                    numbers.addLast(first*second);
                }
                else{
                    numbers.addLast(first/second);
                }
            }
        }
        return numbers.removeLast();
    }
}