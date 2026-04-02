class Solution {
    int minUnf;
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        minUnf = Integer.MAX_VALUE;
        int n=cookies.length;
        int[] children = new int[k];
        helper(cookies, n-1, children, k);
        return minUnf;
    }
    public void helper(int[] cookies, int ind, int[] children, int k){
        if(ind==-1){
            int maxCookies=0;
            for(int child:children){
                if(child>maxCookies){
                    maxCookies=child;
                }
            }
            minUnf = Math.min(minUnf, maxCookies);
            return;
        }
        for(int i=0; i<k; i++){
            children[i] += cookies[ind];
            helper(cookies, ind-1, children, k);
            children[i] -= cookies[ind];
        }
    }
}