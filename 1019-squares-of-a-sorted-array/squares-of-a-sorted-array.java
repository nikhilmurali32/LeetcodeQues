class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        int i=n-1;
        int[] res = new int[n];
        while(l<=r && i>=0){
            if(Math.abs(nums[l])<Math.abs(nums[r])){
                res[i] = nums[r]*nums[r];
                r--;
            }
            else{
                res[i] = nums[l]*nums[l];
                l++;
            }
            i--;
        }
        return res;
    }
}