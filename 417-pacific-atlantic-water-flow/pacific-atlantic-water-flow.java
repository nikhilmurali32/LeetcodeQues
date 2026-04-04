class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        HashSet<int[]> indices = new HashSet<>();
        boolean[][][] visited = new boolean[m][n][2];
        for(int i=0; i<m; i++){
            dfs(heights, i, 0, 0, m, n, visited, 0);
        }
        for(int j=0; j<n; j++){
            dfs(heights, 0, j, 0, m, n, visited, 0);
        }
        for(int i=0; i<m; i++){
            dfs(heights, i, n-1, 0, m, n, visited, 1);
        }
        for(int j=0; j<n; j++){
            dfs(heights, m-1, j, 0, m, n, visited, 1);
        }
        return list;
    }
    public void dfs(int[][] heights, int i, int j, int prevHeight, int m, int n, boolean[][][] visited, int ocean){
        if(i<0 || i>m-1 || j<0 || j>n-1 || heights[i][j]<prevHeight || visited[i][j][ocean]){
            return;
        }
        if(ocean==1 && visited[i][j][0]){
            List<Integer> ind = new ArrayList<>();
            ind.add(i);
            ind.add(j);
            list.add(new ArrayList<>(ind));
        }
        visited[i][j][ocean]=true;
        dfs(heights, i, j+1, heights[i][j], m, n, visited, ocean);
        dfs(heights, i+1, j, heights[i][j], m, n, visited, ocean);
        dfs(heights, i, j-1, heights[i][j], m, n, visited, ocean);
        dfs(heights, i-1, j, heights[i][j], m, n, visited, ocean);
    }
}