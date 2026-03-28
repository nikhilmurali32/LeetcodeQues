class Solution {
    public int numDecodings(String s) {
        int[][] dp = new int[s.length()][10];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        int n=s.length();
        return countWays(s, n-1, -1, n, dp);
    }
    public int countWays(String s, int ind, long prev, int len, int[][] dp){
        long current=s.charAt(ind)-'0';
        if(ind==0){
            if(current==0){
                return 0;
            }
            if(prev==0){
                if(current<=2){
                    return 1;
                }
                return 0;
            }
            if(prev==-1){
                return 1;
            }
            if((current == 1 || (current == 2 && prev<=6))){
                return 2;
            }
            return 1;
        }
        int p=0;
        if(prev!=-1){
            p+=prev;
        }
        if(dp[ind][p] != -1){
            return dp[ind][p];
        }
        int prevTake = 0;
        if((prev != -1) && (current == 1 || (current == 2 && prev<=6))){
            prevTake = countWays(s, ind-1, -1, len, dp);
        }
        int prevNotTake=0;
        if(prev != 0){
            prevNotTake = countWays(s, ind-1, current, len, dp);
        }
        return dp[ind][p] = prevTake + prevNotTake;
    }
}