class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] posTime = new double[n][2];
        for(int i=0; i<n; i++){
            posTime[i][0] = position[i];
            posTime[i][1] = (double)(target-position[i])/speed[i];
        }
        Arrays.sort(posTime, (a,b) -> Double.compare(a[0], b[0]));
        int count=0;
        double currTime=0;
        for(int i=n-1; i>=0; i--){
            if(posTime[i][1]>currTime){
                currTime=posTime[i][1];
                count++;
            }
        }
        return count;
    }
}