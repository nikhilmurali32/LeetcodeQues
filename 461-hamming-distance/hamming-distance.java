class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x^y;
        int count=0;
        while(diff!=0){
            diff = diff&(diff-1);
            count++;
        }
        return count;
    }
}