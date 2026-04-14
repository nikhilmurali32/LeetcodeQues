class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n+1];
        for(int i=0; i<=n; i++){
            int maxRight = Math.min(n, i+ranges[i]);
            int j = Math.max(0, i-ranges[i]);
            maxReach[j] = Math.max(maxReach[j], maxRight);
        }
        int end=0, farthest=0, jump=0;
        for(int i=0; i<n; i++){
            farthest = Math.max(farthest, maxReach[i]);
            if(i==end){
                if(i==farthest){
                    return -1;
                }
                end=farthest;
                jump++;
            }
        }
        return jump;
    }
}