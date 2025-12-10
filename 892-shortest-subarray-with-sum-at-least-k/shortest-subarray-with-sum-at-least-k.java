class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefix = new long[nums.length+1];
        prefix[0]=0;
        for(int i=0; i<nums.length; i++){
            prefix[i+1] = prefix[i]+nums[i];
        }
        int min=Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int j=0; j<=nums.length; j++){
            while(!dq.isEmpty() && prefix[j]-prefix[dq.peekFirst()]>=k){
                min=Math.min(min, j-dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[j]<=prefix[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(j);
        }
        return min==Integer.MAX_VALUE? -1:min;
    }
}