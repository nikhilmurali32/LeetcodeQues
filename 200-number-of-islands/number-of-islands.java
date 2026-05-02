class Solution {
    int m, n;
    class disjointSet{
        int count=0;
        int[] size = new int[m*n];
        int[] parent = new int[m*n];
        disjointSet(){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    parent[i*n + j]=i*n+j;
                    size[i*n+j]=1;
                }
            }
        }
        public int findParent(int cell){
            if(parent[cell]==cell){
                return parent[cell];
            }
            int p = findParent(parent[cell]);
            parent[cell]=p;
            return parent[cell];
        }

        public void joinbySize(int node, int nei_node){
            int ij_parent = findParent(node);
            int nei_ij_parent = findParent(nei_node);
            if(ij_parent==nei_ij_parent){
                return;
            }
            if(size[ij_parent] > size[nei_ij_parent]){
                parent[nei_ij_parent] = parent[ij_parent];
                size[ij_parent] += size[nei_ij_parent];
            }
            else{
                parent[ij_parent] = parent[nei_ij_parent];
                size[nei_ij_parent] += size[ij_parent];                
            }
            count--;
        }
    }
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        disjointSet d = new disjointSet();
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    d.count++;
                    for(int k=0; k<4; k++){
                        int nei_i = i+dirs[k][0];
                        int nei_j = j+dirs[k][1];
                        if(nei_i>=0 && nei_i<m && nei_j>=0 && nei_j<n && grid[nei_i][nei_j]=='1'){
                            d.joinbySize(i*n+j, nei_i*n + nei_j);
                        }
                    }
                }
            }
        }
        return d.count;
    }
}