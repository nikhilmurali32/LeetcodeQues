class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        if(n==0){
            return 0;
        }
        long sum=0, max_elem=piles[0];
        for(int pile:piles){
            sum += (long)pile;
            if((long)pile>max_elem){
                max_elem=(long)pile;
            }
        }
        long l=1;
        long r=max_elem;
        while(l<=r){
            long mid = l-(l-r)/2;
            if(canEat(piles, h, mid)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
            System.out.println(mid);
        }
        return (int)l;
    }
    public boolean canEat(int[] piles, long h, long mid){
        long tot_h=0;
        for(long pile:piles){
            if(pile<=mid){
                tot_h++;
            }
            else{
                if(pile%mid==0){
                    tot_h += ((long)pile/mid);
                }
                else{
                    tot_h = tot_h + ((long)pile/mid)+1;
                }
            }
        }
        if(tot_h<=h){
            return true;
        }
        return false;
    }
}