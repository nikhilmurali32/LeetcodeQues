class Solution {
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        long l=0;
        long r=x/2+1;
        while(l<r){
            long mid=l+(r-l)/2;
            // int sq=mid*mid;
            // if(sq==x){
            //     return mid;
            // }
            if((long)mid*mid<=x){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return (int)l-1;
    }
}