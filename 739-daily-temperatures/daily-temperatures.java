class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        if(n==0){
            return res;
        }
        st.push(0);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
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