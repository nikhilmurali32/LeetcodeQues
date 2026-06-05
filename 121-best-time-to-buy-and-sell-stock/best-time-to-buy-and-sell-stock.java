class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxRight=prices[n-1];
        int max=0;
        for(int i=n-2; i>=0; i--){
            if(prices[i]>=maxRight){
                maxRight = prices[i];
            }
            else{
                max = Math.max(max, maxRight-prices[i]);
            }
        }
        return max;
    }
}