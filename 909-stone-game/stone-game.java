class Solution {
    int alice=0;
    int bob=0;
    public boolean stoneGame(int[] piles) {
        return true;
        // int sum=0;
        // int n=piles.length;
        // for(int i=0; i<n; i++){
        //     sum += piles[i];
        // }
        // helper(piles, 'a', 0, n-1);
        // return alice>bob?true:false;
    }
    public void helper(int[] piles, char c, int l, int r){
        if(l>r){
            return;
        }
        if(c=='a'){
            if(piles[l]>piles[r]){
                alice += piles[l];
                l++;
            }
            else{
                alice += piles[r];
                r--;
            }
            helper(piles, 'b', l, r);
        }
        else{
            if(piles[l]>=piles[r]){
                bob += piles[l];
                l++;
            }
            else{
                bob += piles[r];
                r--;
            }
            helper(piles, 'a', l, r);
        }
    }
}