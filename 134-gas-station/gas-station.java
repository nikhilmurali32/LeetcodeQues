class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas=0, totalCost=0;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost>totalGas){
            return -1;
        }
        int i=0;
        while(i<n){
            if(gas[i]<cost[i]){
                i++;
                continue;
            }
            if(checkComplete(i, gas, cost, 0)==i){
                return i;
            }
            else{
                if(checkComplete(i, gas, cost, 0)<i){
                    return -1;
                }
                i=checkComplete(i, gas, cost, 0);
            }
        }
        return -1;
    }
    public int checkComplete(int i, int[] gas, int[] cost, int remGas){
        int startInd=i;
        int n=gas.length;
        remGas = gas[i]-cost[i];
        i = (i+1)%n;
        while(i != startInd){
            remGas += (gas[i]-cost[i]);
            if(remGas<0){
                return i;
            }
            i = (i+1)%n;
        }
        return i;
    }
}