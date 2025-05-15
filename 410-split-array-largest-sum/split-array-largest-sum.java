class Solution {
    public int splitArray(int[] nums, int k) {
        int max_in_nums=nums[0];
        int sum_of_nums=0;
        for(int num:nums){
            if(num>max_in_nums){
                max_in_nums=num;
            }
            sum_of_nums += num;
        }
        int l=max_in_nums;
        int r=sum_of_nums;
        int total_sum=r;
        while(l<r){
            int mid=(l+r)/2;
            int sum=0;
            int i=0;
            int count=0;
            while(i<nums.length){
                sum += nums[i];
                if(sum>mid){
                    count++;
                    sum=0;
                    i--;
                }
                i++;
            }
            if(count<k){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}