class Solution {
    int count=0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        count++;
        dfs(rooms, vis, 0);
        return count==rooms.size();
    }
    public void dfs(List<List<Integer>> rooms, boolean[] vis, int ind){
        for(int room:rooms.get(ind)){
            if(vis[room] || room==ind){
                continue;
            }
            vis[room]=true;
            count++;
            dfs(rooms, vis, room);
        }
    }
}