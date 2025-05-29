class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=2; i<n; i++){
            int l=0;
            int r=i-1;
            while(l<r){
                int sum=nums[l]+nums[r];
                if(nums[i]<sum){
                    count += (r-l);
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return count;
    }
}