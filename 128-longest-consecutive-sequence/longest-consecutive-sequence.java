class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hset.add(nums[i]);
        }
        HashSet<Integer> hset_curr = new HashSet<>();
        int max=1;
        for(int i=0; i<nums.length; i++){
            int ele=nums[i];
            if(hset_curr.contains(ele)){
                continue;
            }
            hset_curr.add(ele);
            int count=1;
            int prev=ele-1;
            int next=ele+1;              
            while(hset_curr.add(prev) && hset.contains(prev)){
                hset_curr.add(prev);
                prev--;
                count++;
            }
            while(hset_curr.add(next) && hset.contains(next)){
                hset_curr.add(next);
                next++;
                count++;          
            }
            max=Math.max(max, count); 
        }
        return max;
    }
}