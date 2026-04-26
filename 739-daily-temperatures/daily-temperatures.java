class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> temp = new ArrayDeque<>();
        for(int i=0; i<temperatures.length; i++){
            while(!temp.isEmpty() && temperatures[i]>temperatures[temp.peekLast()]){
                temperatures[temp.peekLast()] = i-temp.removeLast();
            }
            temp.addLast(i);
        }
        while(!temp.isEmpty()){
            temperatures[temp.remove()]=0;
        }
        return temperatures;
    }
}