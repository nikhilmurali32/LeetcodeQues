class Solution {
    public int uniquePaths(int m, int n) {
        int left=1, tot=1;
        int[] top = new int[n];
        Arrays.fill(top, 1);
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                tot = left + top[j];
                left=tot;
                top[j]=tot;
            }
            left=1;
        }
        return tot;
    }
}