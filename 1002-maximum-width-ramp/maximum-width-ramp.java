class Solution {
    // stack A: [0,1] // inc stack to store i index
    // stack B: [5,2] // dec stack to store j index
    // iterate both the stacks to try out every poss, and store max
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stacki = new ArrayDeque<>();
        Deque<Integer> stackj = new ArrayDeque<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(stacki.isEmpty() || nums[i]<nums[stacki.peekLast()]){
                stacki.addLast(i);
            }
        }
        int rightMax=0;
        int max=0;
        for(int i=n-1; i>=0; i--){
            while(!stacki.isEmpty() && nums[i]>=nums[stacki.peekLast()]){
                max = Math.max(max, i-stacki.removeLast());
            }
        }
        return max;
    }
}