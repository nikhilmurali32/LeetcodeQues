class Solution {
    public int sumOfPrimesInRange(int n) {
        String str = String.valueOf(n);
        String rev = "";
        for(int i=str.length()-1; i>=0; i--){
            rev += str.charAt(i);
        }
        int flip = Integer.valueOf(rev);
        int l=Math.min(flip, n);
        int r=Math.max(flip, n);
        int sum=0;
        for(int i=l; i<=r; i++){
            if(isPrime(i)){
                sum += i;
            }
        }
        return sum;
    }
    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3; i<=Math.sqrt(n); i += 2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}