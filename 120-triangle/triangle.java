class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp = new int[n];
        int[] dp_copy = new int[n];
        dp[0]=triangle.get(0).get(0);
        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(j==0){
                    dp_copy[j] = triangle.get(i).get(0)+dp[j];
                }
                else if(j==i){
                    dp_copy[j] = triangle.get(i).get(j)+dp[j-1];
                }
                else{
                    dp_copy[j] = Math.min(triangle.get(i).get(j)+dp[j], triangle.get(i).get(j)+dp[j-1]);
                }
            }
            dp = Arrays.copyOfRange(dp_copy, 0, n);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min=Math.min(min, dp[i]);
        }
        return min;
    }
}