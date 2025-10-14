class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0; i<nums.length; i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return target;
                }
                else if(sum<target){
                    l++;
                }
                else{
                    r--;
                }
                if(Math.abs(target-sum)<min){
                    min=Math.abs(target-sum);
                    ans=sum;
                }
            }
        }
        return ans;
    }
}