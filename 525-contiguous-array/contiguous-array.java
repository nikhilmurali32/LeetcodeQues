class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count=0;
        hmap.put(0, -1);
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count--;
            }
            else{
                count++;
            }
            if(!hmap.containsKey(count)){
                hmap.put(count, i);
            }
            else{
                max=Math.max(max, i-hmap.get(count));
            }
        }
        return max;
    }
}