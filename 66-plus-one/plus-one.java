class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        if(digits[n-1]<9){
            digits[n-1]++;
            return digits;
        }
        int i=n-1;
        while(i>0 && digits[i]==9){
            digits[i]=0;
            if(digits[i-1]+1<=9){
                digits[i-1]++;
                return digits;
            }
            i--;
        }
        int[] res = new int[n+1];
        res[0]=1;
        return res;

    }
}