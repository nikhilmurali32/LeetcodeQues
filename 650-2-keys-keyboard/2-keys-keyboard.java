class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        if(isPrime(n)){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1]=0;
        for(int i=2; i<=n; i++){
            if( (i==2) || (i%2 != 0 && isPrime(i))){
                dp[i]=i;
            }
            else{
                int fact=lastFactor(i);
                dp[i]=dp[fact] + 1 + (i/fact)-1;
            }
        }
        return dp[n];
    }
    public int lastFactor(int n){
        if(n%2 == 0){
            return n/2;
        }
        int start=n/2;
        for(int i=start; i>0; i--){
            if(n%i == 0){
                return i;
            }
        }
        return 1;
    }
    public boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}