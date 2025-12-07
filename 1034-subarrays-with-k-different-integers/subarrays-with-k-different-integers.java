class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int[] nums, int k){
        int i=0, j=0;
        int res=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        while(j<nums.length){
            hmap.put(nums[j], hmap.getOrDefault(nums[j],0)+1);
            if(hmap.get(nums[j])==1){
                k--;
            }
            while(k<0){
                if(hmap.get(nums[i])>1){
                    hmap.put(nums[i], hmap.get(nums[i])-1);
                }
                else if(hmap.get(nums[i])==1){
                    hmap.put(nums[i], hmap.get(nums[i])-1);
                    k++;
                }
                i++;
            }
            res += (j-i+1);
            j++;
        }
        return res;
    }
}