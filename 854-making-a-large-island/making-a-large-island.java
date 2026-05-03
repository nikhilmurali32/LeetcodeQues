class Solution {
    int m, n;
    int maxArea=1;
    class disjointSet{
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
                maxArea = Math.max(maxArea, size[ij_parent]);
            }
            else{
                parent[ij_parent] = parent[nei_ij_parent];
                size[nei_ij_parent] += size[ij_parent];
                maxArea = Math.max(maxArea, size[nei_ij_parent]);                
            }
        }
        int currArea=0;
    }
    public int largestIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        if(m==0 && n==0){
            return 0;
        }
        disjointSet d = new disjointSet();
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    for(int k=0; k<4; k++){
                        int nei_i = i+dirs[k][0];
                        int nei_j = j+dirs[k][1];
                        if(nei_i>=0 && nei_i<m && nei_j>=0 && nei_j<n && grid[nei_i][nei_j]==1){
                            d.joinbySize(i*n+j, nei_i*n + nei_j);
                        }
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    HashSet<Integer> neiP = new HashSet<>();
                    d.currArea=1;
                    for(int k=0; k<4; k++){
                        int nei_i = i+dirs[k][0];
                        int nei_j = j+dirs[k][1];
                        if(nei_i>=0 && nei_i<m && nei_j>=0 && nei_j<n && grid[nei_i][nei_j]==1 && neiP.add(d.findParent(n*nei_i+nei_j))){
                            d.currArea += d.size[d.findParent(n*nei_i+nei_j)];
                        }
                    }
                    maxArea = Math.max(maxArea, d.currArea);
                }
            }
        }
        return maxArea;
    }
}