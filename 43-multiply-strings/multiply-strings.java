class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length(), n=num2.length();
        int[] res = new int[m+n+1];
        int carry = 0;
        int k = m+n;
        for(int i=n-1; i>=0; i--){
            int n2 = num2.charAt(i)-'0';
            int ind=k;
            for(int j=m-1; j>=0; j--){
                int n1 = num1.charAt(j)-'0';
                int ans = n1*n2 + carry;
                int carryArr = (res[ind] + (ans % 10))/10;
                res[ind] = (res[ind] + (ans % 10))%10;
                // System.out.println(res[ind]);
                carry = carryArr+ (int)(ans / 10);
                ind--;
            }
            if(carry>0){
                res[ind]=carry;
            }
            carry=0;
            k--;
        }
        int i=0;
        while(i<m+n+1 && res[i]==0){
            i++;
        }
        StringBuilder finalString = new StringBuilder();
        while(i<m+n+1 && i<res.length){
            finalString.append(String.valueOf(res[i]));
            i++;
        }
        String s = finalString.toString();
        return s.length()==0?"0":s;
    }
}