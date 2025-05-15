class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max_weight=weights[0];
        int sum=0;
        for(int weight:weights){
            if(weight>max_weight){
                max_weight=weight;
            }
            sum += weight;
        }
        int l=max_weight;
        int r=sum;
        while(l<r){
            int mid=(l+r)/2;
            int days_taken=0;
            int i=0;
            sum=0;
            while(i<weights.length){
                sum += weights[i];
                if(sum>mid){
                    days_taken++;
                    sum=0;
                    i--;
                }
                i++;
            }
            if(days_taken<days){
                r=mid;
            }
            else{
                l=mid+1;
            }

        }
        return l;
    }
}