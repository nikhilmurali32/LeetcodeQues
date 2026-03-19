class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        if(isPrime(n)){
            return n;
        }
        int[] dp = new int[n/2+1];
        dp[1]=0;
        int end = lastFactor(n);
        int i=2;
        while(i<=end){
            if( (i==2) || (i%2 != 0 && isPrime(i))){
                dp[i]=i;
            }
            else{
                int fact=lastFactor(i);
                dp[i]=dp[fact] + 1 + (i/fact)-1;
            }
            i++;
        }
        return dp[i-1] + 1 + (n/end)-1;
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