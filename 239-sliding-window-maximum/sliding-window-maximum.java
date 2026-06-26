class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i=0, j=0;
        int n = nums.length;
        int[] res = new int[n-k+1];
        int ind=0;
        while(i<=j && j<n){
            if(j-i<k){
                while(!dq.isEmpty() && nums[j]>nums[dq.peekLast()]){
                    dq.removeLast();
                }
                dq.addLast(j);
                j++;
            }
            else{
                res[ind]=nums[dq.peekFirst()];
                ind++;
                if(i==dq.peekFirst()){
                    dq.removeFirst();
                }
                i++;
            }
        }
        if(!dq.isEmpty()){
            res[ind]=nums[dq.peekFirst()];
        }
        return res;
    }
}