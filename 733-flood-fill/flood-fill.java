class Solution {
    int prev_color;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        prev_color=image[sr][sc];
        dfs(image, sr, sc, color);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color){
        if(sr<0 || sr>image.length-1 || sc<0 || sc>image[0].length-1 || image[sr][sc]==color || image[sr][sc]!=prev_color){
            return;
        }
        // if(image[sr][sc]==prev_color){
        image[sr][sc]=color;
        // }
        dfs(image, sr, sc+1, color);
        dfs(image, sr+1, sc, color);
        dfs(image, sr, sc-1, color);
        dfs(image, sr-1, sc, color);
    }
}