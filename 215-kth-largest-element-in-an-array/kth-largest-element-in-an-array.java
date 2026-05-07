class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        if(n==1 && k==n){
            return nums[0];
        }
        return quickSelect(nums, 0, n-1, nums.length-k);
    }
    public int quickSelect(int[] nums, int l, int r, int k){
        if(l<=r){
            int pivot = findPivotIndex(nums, l, r, k);
            if(pivot==k){
                return nums[pivot];
            }
            else if(pivot<k){
                return quickSelect(nums, pivot+1, r, k);
            }
            else{
                return quickSelect(nums, l, pivot-1, k);
            }
        }
        return -1;
    }
    public int findPivotIndex(int[] nums, int l, int r, int k){
        int pivot = l + (r-l)/2;
        int ind=l;
        swap(nums, l, pivot);
        while(l<r){
            while(l<=r && nums[l]<=nums[ind]){
                l++;
            }
            while(l<=r && nums[r]>nums[ind]){
                r--;
            }
            if(l<r){
                swap(nums, l, r);
            }
        }
        if(r>=0){
            swap(nums, r, ind);
        }
        return r;
    }
    public void swap(int[] nums, int l, int r){
        int temp = nums[r];
        nums[r]=nums[l];
        nums[l]=temp;
    }
}