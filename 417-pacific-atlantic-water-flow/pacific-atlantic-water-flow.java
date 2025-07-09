class Solution {
    int m;
    int n;
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for(int i=0; i<m; i++){
            dfs(heights, i, 0, pac, heights[i][0]);
            dfs(heights, i, n-1, atl, heights[i][n-1]);
        }
        for(int j=0; j<n; j++){
            dfs(heights, 0, j, pac, heights[0][j]);
            dfs(heights, m-1, j, atl, heights[m-1][j]);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pac[i][j] && atl[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public void dfs(int[][] heights, int i, int j, boolean[][] vis, int prev){
        if(i<0 || i>m-1 || j<0 || j>n-1 || vis[i][j] || heights[i][j]<prev ){
            return;
        }
        vis[i][j]=true;
        dfs(heights, i+1, j, vis, heights[i][j]);
        dfs(heights, i, j+1, vis, heights[i][j]);
        dfs(heights, i-1, j, vis, heights[i][j]);
        dfs(heights, i, j-1, vis, heights[i][j]);
    }
}