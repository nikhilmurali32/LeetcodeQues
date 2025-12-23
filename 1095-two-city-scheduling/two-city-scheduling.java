class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int sum=0;
        int[] diff = new int[n];
        for(int i=0; i<n; i++){
            diff[i] = costs[i][0]-costs[i][1];
            sum += costs[i][1];
        }
        Arrays.sort(diff);
        for(int j=0; j<n/2; j++){
            sum += diff[j];
        }
        return sum;
    }
}