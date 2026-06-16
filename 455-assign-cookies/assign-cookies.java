class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int i = m-1, j=n-1;
        int count=0;
        while(i>=0 && j>=0){
            if(s[j] >= g[i]){
                count++;
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        return count;
    }
}