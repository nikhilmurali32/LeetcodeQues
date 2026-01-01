class Solution {
    boolean done=false;
    public boolean canReach(int[] arr, int start) {
        boolean[] vis=new boolean[arr.length];
        return helper(arr, start, vis);
    }
    public boolean helper(int[] arr, int start, boolean[] vis){
        // if(done){
        //     return true;
        // }
        if(start<0 || start>=arr.length || vis[start]){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        vis[start]=true;
        // if(helper(arr, start+arr[start], vis)){
        //     // done=true;
        //     return true;
        // }
        // if(helper(arr, start-arr[start], vis)){
        //     done=true;
        //     return true;
        // }
        return helper(arr, start+arr[start], vis) || helper(arr, start-arr[start], vis);
        // return false;
    }
}