class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0]=1;
        suff[n-1]=1;
        int i=1;
        while(i<n){
            pref[i]=pref[i-1]*nums[i-1];
            suff[n-i-1]=suff[n-i]*nums[n-i];
            i++;
        }
        for(int j=0; j<n; j++){
            // System.out.println(pref[j]);
            // System.out.println(suff[j]);
            nums[j]=pref[j]*suff[j];
        }
        return nums;

    }
}