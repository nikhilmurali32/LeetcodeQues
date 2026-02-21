class Solution {
    public boolean isPalindrome(int x) {
        int num=x;
        if(x<0){
            return false;
        }
        int rev=0;
        while(x>0){
            int rem=x%10;
            rev = rev*10 + rem;
            x=x/10;
        }
        System.out.println(rev);
        return rev==num;
    }
}