class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashSet<Integer> hset = new HashSet<>();
        for(int num:nums){
            hset.add(num);
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
            if(hmap2.size()==hset.size()){
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