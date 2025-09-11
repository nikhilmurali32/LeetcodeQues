class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        if(n==k){
            return nums;
        }
        int rem=n-k;
        int i=0;
        Stack<Integer> st = new Stack<>();
        while(i<n){
            while(rem>0 && !st.isEmpty() && st.peek()>nums[i]){
                System.out.println(st.pop());
                rem--;
            }
            st.push(nums[i]);
            i++;
        }
        int[] ans = new int[k];
        int j=k-1;
        while(st.size()!=k){
            st.pop();
        }
        while(j>=0 && !st.isEmpty()){
            ans[j]=st.pop();
            j--;
        }
        return ans;
    }
}