class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        for(int i=0; i<n-1; i++){
            prices[i]=prices[i+1]-prices[i];
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int j=0; j<n-1; j++){
            sum += prices[j];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max>0? max:0;
    }
}