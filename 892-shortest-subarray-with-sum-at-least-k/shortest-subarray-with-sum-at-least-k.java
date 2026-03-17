class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] sum = new long[n+1];
        for(int i=0; i<n; i++){
            sum[i+1] = sum[i]+nums[i];
        }
        int min=Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<=n; i++){
            while(!dq.isEmpty() && sum[i]<=sum[dq.peekLast()]){
                dq.removeLast();
            }
            while(!dq.isEmpty() && sum[i]-sum[dq.peekFirst()]>=k){
                min = Math.min(min, i-dq.peekFirst());
                dq.removeFirst();
            }
            dq.addLast(i);
        }
        return min==Integer.MAX_VALUE? -1:min;
    }
}