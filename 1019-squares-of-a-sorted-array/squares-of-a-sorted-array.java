class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] newNums = new int[n];
        int l=0, r=n-1;
        int i=n-1;
        while(l<=r){
            if(Math.abs(nums[l])>=Math.abs(nums[r])){
                newNums[i]=nums[l];
                l++;
            }
            else{
                newNums[i]=nums[r];
                r--;
            }
            i--;
        }
        for(int j=0; j<n; j++){
            newNums[j] *=newNums[j];
        }
        return newNums;
    }
}