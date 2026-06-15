class Solution {
    public int jump(int[] nums) {
        int currStart=0, currEnd=0, jump=0, farthest=0, n=nums.length;
        if(n==1){
            return 0;
        }
        for(int i=0; i<n; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(i==currEnd){
                jump++;
                currEnd=farthest;
                if(currEnd >= n-1){
                    return jump;
                }
            }
        }
        return jump;
    }
}