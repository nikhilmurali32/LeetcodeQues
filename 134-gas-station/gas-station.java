class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int[] diff = new int[n];
        for(int i=0; i<n; i++){
            diff[i]=gas[i]-cost[i];
        }
        int i=0;
        if(n==1){
            if(diff[0]>=0){
                return 0;
            }
            return -1;
        }
        while(i<n){
            if(diff[i]>0){
                if(isPossible(i, diff)){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
    public boolean isPossible(int i, int[] diff){
        int count=0, sum=0, n=diff.length;
        while(count!=n){
            sum += diff[(i+n)%n];
            if(sum<0){
                return false;
            }
            count++;
            i++;
        }
        return true;
    }
}