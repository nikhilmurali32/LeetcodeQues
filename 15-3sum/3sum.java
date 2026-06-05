class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = nums[i];
            int l=i+1, r=n-1;
            while(l<r){
                int sum = first + nums[l] + nums[r];
                if(sum==0){
                    res.add(new ArrayList<>(Arrays.asList(first, nums[l], nums[r])));
                    l++;
                    r--;
                    while(l>0 && l<n && nums[l]==nums[l-1]){
                        l++;
                    }
                    while(r<n-1 && r>=0 && nums[r]==nums[r+1]){
                        r--;
                    }
                }
                else if(sum<0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return res;
    }
}