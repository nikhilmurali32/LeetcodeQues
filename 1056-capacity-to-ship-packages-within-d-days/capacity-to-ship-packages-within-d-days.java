class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=weights[0], sum=0;
        for(int num:weights){
            max=Math.max(max, num);
            sum += num;
        }
        int l=max;
        int r=sum;
        while(l<r){
            int mid=(l+r)/2;
            if(!canShip(weights, mid, days)){
                l=mid+1;
            }
            else{
                r=mid;
            }
            System.out.println(mid);
        }
        return l;
    }
    public boolean canShip(int[] weights, int cap, int days){
        int tot=0;
        int i=0;
        while(i<weights.length){
            tot+=weights[i];
            if(tot>cap){
                days--;
                tot=weights[i];
            }
            i++;
        }
        if(tot>0){
            days--;
        }
        if(days<0){
            return false;
        }
        return true;
    }
}