class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && (long)nums[i]==(long)nums[i-1]){
                continue;
            }
            long first = (long)nums[i];
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && (long)nums[j]==(long)nums[j-1]){
                    continue;
                }
                long second = (long)nums[j];
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    long sum = first+second+(long)nums[l]+(long)nums[r];
                    if(sum==(long)target){
                        list.add(Arrays.asList((int)first, (int)second, nums[l], nums[r]));
                        l++;
                        r--;
                        while(l<r && (long)nums[l]==(long)nums[l-1]){
                            l++;
                        }
                        while(l<r && (long)nums[r]==(long)nums[r+1]){
                            r--;
                        }
                    }
                    else if(sum<(long)target){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return list;
    }
}