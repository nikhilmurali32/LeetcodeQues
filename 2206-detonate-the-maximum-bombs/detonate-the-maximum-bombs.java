class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans=0;
        for(int i=0; i<bombs.length; i++){
            ans=Math.max(ans, dfs(i, new boolean[bombs.length], bombs));
        }
        return ans;
    }
    public int dfs(int idx, boolean[] vis, int[][] bombs){
        int count=1;
        vis[idx]=true;
        for(int i=0; i<bombs.length; i++){
            if(!vis[i] && inRange(bombs[idx], bombs[i])){
                count += dfs(i, vis, bombs);
            }
        }
        return count;
    }
    public boolean inRange(int[] x, int[] y){
        long x_dist=x[0]-y[0];
        long y_dist=x[1]-y[1];
        long r = x[2];
        return x_dist*x_dist + y_dist*y_dist <= r*r;
    }
}