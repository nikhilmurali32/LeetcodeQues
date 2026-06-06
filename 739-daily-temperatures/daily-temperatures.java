class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n=temperatures.length;
        int i=0;
        while(i<n){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peekLast()]){
                temperatures[stack.peekLast()] = i-stack.removeLast();
            }
            stack.addLast(i);
            i++;
        }
        while(!stack.isEmpty()){
            temperatures[stack.removeLast()]=0;
        }
        return temperatures;
    }
}