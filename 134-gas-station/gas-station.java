class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, currGas=0;
        int startInd=0;
        int n=gas.length;
        for(int i=0; i<n; i++){
            totalGas += (gas[i]-cost[i]);
            currGas += (gas[i]-cost[i]);
            if(currGas<0){
                startInd = i+1;
                currGas=0;
            }
        }
        if(totalGas<0){
            return -1;
        }
        return startInd;
    }
}