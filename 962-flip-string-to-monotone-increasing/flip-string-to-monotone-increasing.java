class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int[] ones_before = new int[n];
        int[] zeros_after = new int[n];

        for(int i=1; i<n; i++){
            if(s.charAt(i-1)=='1'){
                ones_before[i] = ones_before[i-1]+1;
            }
            else{
                ones_before[i]=ones_before[i-1];
            }
        }
        for(int i=n-2; i>=0; i--){
            if(s.charAt(i+1)=='0'){
                zeros_after[i] = zeros_after[i+1]+1;
            }
            else{
                zeros_after[i]=zeros_after[i+1];
            }
        }
        int res=n;
        for(int i=0; i<n; i++){
            res = Math.min(res, ones_before[i]+zeros_after[i]);
        }
        return res;
    }
}