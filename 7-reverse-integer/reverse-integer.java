class Solution {
    public int reverse(int x) {
        if(x==0 || x==-2147483648){
            return 0;
        }
        boolean neg=false;
        if(x<0){
            x=x*-1;
            neg=true;
        }
        String s="";
        while(x>0){
            s += String.valueOf(x%10);
            x=x/10;
        }

        long res=Long.parseLong(s);
        if(res>Integer.MAX_VALUE){
            return 0;
        }
        if(neg){
            res = res*-1;
        }
        return (int)res;

    }
}