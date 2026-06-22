class Solution {
    // arr[i]-arr[j]<=a
    //-arr[i]+arr[j]<=a

    // mod(a-b)<=c
    // a-b<=c, b-a<=c
    // a<=c+b, a>=b-c
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=arr.length;
        int ans=0;
        int[] prefix=new int[1001];
        int[] freq=new int[1001];
        for(int j=0; j<n; j++){
            for(int k=j+1; k<n; k++){
                if(Math.abs(arr[j]-arr[k])<=b){
                    int L = Math.max(0, Math.max(arr[j]-a, arr[k]-c));
                    int R = Math.min(1000, Math.min(a+arr[j], c+arr[k]));
                    if(L<=R){
                        ans += (prefix[R]-(L>0?prefix[L-1]:0));
                    }
                }
            }
            freq[arr[j]]++;
            prefix[0]=freq[0];
            for(int i=1; i<=1000; i++){
                prefix[i] = prefix[i-1]+freq[i];
            }
        }
        return ans;
    }
}