class Solution {
    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int totalCount=0;
        for(int i=1; i<n+1; i++){
            int countLeft = numTrees(i-1);
            int countRight = numTrees(n-i);
            totalCount += countLeft*countRight;
        }
        return totalCount;
    }
}