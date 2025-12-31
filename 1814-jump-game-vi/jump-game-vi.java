class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq= new LinkedList<>();
        int i=1;
        int n=nums.length;
        int[] res = new int[n];
        res[0]=nums[0];
        dq.addLast(0);
        while(i<n){
            if(dq.peekFirst() < i-k){
                dq.pollFirst();
            }
            res[i]=nums[i]+res[dq.peekFirst()];
            while(!dq.isEmpty() && res[dq.peekLast()]<=res[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            i++;
        }
        return res[n-1];
    }
}