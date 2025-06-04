class Solution {
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length;
        n=image[0].length;
        boolean[][] vis = new boolean[m][n];
        int rep = image[sr][sc];
        dfs(image, sr, sc, color, vis, rep);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, boolean[][] vis, int rep){
        if(sr<0 || sr>m-1 || sc<0 || sc>n-1 || image[sr][sc]!=rep){
            return;
        }
        if(vis[sr][sc]){
            return;
        }
        vis[sr][sc]=true;
        image[sr][sc]=color;
        dfs(image, sr+1, sc, color, vis, rep);
        dfs(image, sr, sc+1, color, vis, rep);
        dfs(image, sr-1, sc, color, vis, rep);
        dfs(image, sr, sc-1, color, vis, rep);
    }
}