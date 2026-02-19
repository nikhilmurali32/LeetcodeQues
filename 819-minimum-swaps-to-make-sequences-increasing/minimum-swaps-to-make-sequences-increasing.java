class Solution {
    int[] arr1, arr2;
    int ans;
    Integer[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][2];
        arr1 = Arrays.copyOf(nums1, nums1.length);
        arr2 = Arrays.copyOf(nums2, nums1.length);
        ans=nums1.length;
        return Math.min(helper(1, 0), 1+helper(1,1));
    }
    public int helper(int ind, int prevSwapped){
        // System.out.println("Count: " + count);
        // System.out.println("Index: " + ind);
        // if(ind==arr1.length){
        //     ans=Math.min(ans,count);
        //     return;
        // }
        // if(count>=ans){
        //     return;
        // }
        // if(isValid(ind)){
        //     helper(ind+1, count);
        // }

        // swap(ind);
        // if(isValid(ind)){
        //     helper(ind+1, count+1);
        // }
        // swap(ind);
        if(ind==arr1.length){
            return 0;
        }
        if (dp[ind][prevSwapped] != null){
            return dp[ind][prevSwapped];
        }
        int prev1 = arr1[ind-1], prev2 = arr2[ind-1];
        if(prevSwapped==1){
            prev1=arr2[ind-1];
            prev2 = arr1[ind-1];
        }
        int ans = Integer.MAX_VALUE;
        if(prev1<arr1[ind] && prev2<arr2[ind]){
            ans = helper(ind+1, 0);
        }
        if(prev2<arr1[ind] && prev1<arr2[ind]){
            ans = Math.min(ans, 1+helper(ind+1, 1));
        }
        dp[ind][prevSwapped]=ans;
        return dp[ind][prevSwapped];
    }
    // public boolean isValid(int ind){
    //     if(ind==0){
    //         return true;
    //     }
    //     return arr1[ind-1]<arr1[ind] && arr2[ind-1]<arr2[ind];
    // }
    // public void swap(int ind){
    //     int temp=arr1[ind];
    //     arr1[ind]=arr2[ind];
    //     arr2[ind]=temp;
    // }
}