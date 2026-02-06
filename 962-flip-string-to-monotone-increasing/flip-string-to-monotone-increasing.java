class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int[] ones_before = new int[n+1];
        int[] zeros = new int[n+1];

        for(int i=1; i<=n; i++){
            if(s.charAt(i-1)=='1'){
                ones_before[i] = ones_before[i-1]+1;
            }
            else{
                ones_before[i]=ones_before[i-1];
            }
        }
        // if(s.charAt(n-1)=='0'){
        //     zeros[n-1]=1;
        // }
        // for(int i=n-1; i>=0; i--){
        //     if(s.charAt(i)=='0'){
        //         zeros[i] = zeros[i+1]+1;
        //     }
        //     else{
        //         zeros[i]=zeros[i+1];
        //     }
        // }
        int res=n;
        for(int i=0; i<=n; i++){
            res = Math.min(res, ones_before[i]+((n-i)-(ones_before[n]-ones_before[i])));
        }
        return res;
    }
}