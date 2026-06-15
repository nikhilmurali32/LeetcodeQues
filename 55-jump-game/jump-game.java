class Solution {
    public boolean canJump(int[] nums) {
        int farthest=0;
        int n=nums.length-1;
        for(int i=0; i<n; i++){
            if(i<=farthest){
                farthest = Math.max(farthest, i+nums[i]);
                if(farthest>=n){
                    break;
                }
            }
            else{
                break;
            }
        }
        return farthest>=n;
    }
}