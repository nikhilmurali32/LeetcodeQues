class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num:nums){
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }
        HashMap<Integer, Integer> hmap2 = new HashMap<>();
        int i=0;
        int j=0;
        int count=0;
        boolean check=false;
        while(j<n){
            if(!check){
                hmap2.put(nums[j], hmap2.getOrDefault(nums[j], 0)+1);
            }
            if(hmap2.size()==hmap.size()){
                count += (n-j);
                hmap2.put(nums[i], hmap2.get(nums[i])-1);
                if(hmap2.get(nums[i])==0){
                    hmap2.remove(nums[i]);
                    i++;
                    j++;
                    check=false;
                    continue;
                }
                i++;
                check=true;
            }
            else{
                j++;
                check=false;
            }
        }
        return count;
    }
}