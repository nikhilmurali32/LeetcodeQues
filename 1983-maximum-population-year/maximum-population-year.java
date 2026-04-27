class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] pop = new int[2051];
        int res=0;
        for(int[] log:logs){
            pop[log[0]]++;
            pop[log[1]]--;
        }
        for(int i=1950; i<=2050; i++){
            pop[i] += pop[i-1];
            if(pop[i]>pop[res]){
                res=i;
            }
        }
        return res;
    }
}