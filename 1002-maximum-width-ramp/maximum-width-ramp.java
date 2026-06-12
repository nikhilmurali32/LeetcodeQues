class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stacki = new ArrayDeque<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(stacki.isEmpty() || nums[i]<nums[stacki.peekLast()]){
                stacki.addLast(i);
            }
        }
        int max=0;
        for(int i=n-1; i>=0; i--){
            while(!stacki.isEmpty() && nums[i]>=nums[stacki.peekLast()]){
                max = Math.max(max, i-stacki.removeLast());
            }
        }
        return max;
    }
}