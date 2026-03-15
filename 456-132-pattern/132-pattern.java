class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        int third=Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]<third){
                return true;
            }
            while(!dq.isEmpty() && nums[i]>dq.peekLast()){
                third = dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        return false;
    }
}