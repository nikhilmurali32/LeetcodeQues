class Solution {
    int[] res;
    boolean[] used;
    public int[] constructDistancedSequence(int n) {
        res = new int[2*(n-1)+1];
        used = new boolean[n+1];
        helper(0, n);
        return res;
    }
    public boolean helper(int ind, int n){
        if(ind==res.length){
            return true;
        }
        if(res[ind]!=0){
            return helper(ind+1, n);
        }
        for(int i=n; i>=1; i--){
            if(used[i]){
                continue;
            }
            if(i==1){
                res[ind]=1;
                used[i]=true;
                if(helper(ind+1, n)){
                    return true;
                }
                res[ind]=0;
                used[i]=false;
            }
            else{
                int j=ind+i;
                if(j<res.length && res[ind]==0 && res[j]==0){
                    res[ind]=i;
                    res[j]=i;
                    used[i]=true;
                    if(helper(ind+1, n)){
                        return true;
                    }
                    res[ind]=0;
                    res[j]=0;
                    used[i]=false;
                }
            }
        }
        return false;
    }
}