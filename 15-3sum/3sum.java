class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hset = new HashSet<>();
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = nums[i];
            for(int j=i+1; j<n-1; j++){
                int second = nums[j];
                int l=j+1, r=n-1;
                while(l<r){
                    int mid = l + (r-l)/2;
                    if(nums[mid] < -1*(first+second)){
                        l = mid+1;
                    }
                    else{
                        r = mid;
                    }
                }
                if(nums[l] == -1*(first+second)){
                    hset.add(new ArrayList<>(Arrays.asList(first, second, nums[l])));
                }
            }
        }
        for(List<Integer> arr:hset){
            res.add(arr);
        }
        return res;
    }
}