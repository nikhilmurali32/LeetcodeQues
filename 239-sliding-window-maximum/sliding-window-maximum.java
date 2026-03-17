class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int i=0, j=0;
        int[] res = new int[n-k+1];
        int ind=0;
        while(j<n){
            if(j-i<k){
                while(!dq.isEmpty() && nums[j]>dq.peekLast()){
                    dq.removeLast();
                }
                dq.addLast(nums[j]);
                j++;
            }
            else{
                res[ind]=dq.peekFirst();
                ind++;
                if(nums[i]==dq.peekFirst()){
                    dq.removeFirst();
                }
                while(!dq.isEmpty() && nums[j]>dq.peekLast()){
                    dq.removeLast();
                }
                dq.addLast(nums[j]);
                while(dq.size()>k){
                    dq.removeFirst();
                }
                j++;
                i++;

            }
        }
        while(dq.size()>k){
            dq.removeFirst();
        }
        res[ind]=dq.peekFirst();
        return res;
    }
}