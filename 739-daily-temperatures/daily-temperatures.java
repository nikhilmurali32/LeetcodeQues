class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[n];
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                res[st.peek()]=i-st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            res[st.pop()]=0;
        }
        return res;
    }
}