class Solution {
    boolean[] vis;
    public boolean canReach(int[] arr, int start) {
        vis = new boolean[arr.length];
        return helper(arr, start);
    }
    public boolean helper(int[] arr, int start){
        if(start<0 || start>arr.length-1 || vis[start]){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        vis[start]=true;
        return (helper(arr, start+arr[start]) || helper(arr, start-arr[start]));
    }
}