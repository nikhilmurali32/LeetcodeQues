class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp = new int[n];
        dp[0]=triangle.get(0).get(0);
        for(int i=1; i<n; i++){
            for(int j=i; j>=0; j--){
                if(j==0){
                    dp[j] = triangle.get(i).get(0)+dp[j];
                }
                else if(j==i){
                    dp[j] = triangle.get(i).get(j)+dp[j-1];
                }
                else{
                    dp[j] = Math.min(triangle.get(i).get(j)+dp[j], triangle.get(i).get(j)+dp[j-1]);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min=Math.min(min, dp[i]);
        }
        return min;
    }
}