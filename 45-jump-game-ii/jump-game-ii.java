class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int start=0, end=0, farthest=0, jump=0;
        for(int i=0; i<n; i++){
            farthest=Math.max(farthest, i+nums[i]);
            if(i==end){
                if(i==n-1){
                    return jump;
                }
                jump++;
                end=farthest;
            }
        }
        return jump;
    }
}