class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num:nums){
            if(!hmap.containsKey(num)){
                int left = hmap.containsKey(num-1) ? hmap.get(num-1):0;
                int right = hmap.containsKey(num+1) ? hmap.get(num+1):0;
                int sum = left+right+1;
                hmap.put(num, sum);
                max=Math.max(max, sum);
                hmap.put(num-left, sum);
                hmap.put(num+right, sum);
            }
            else{
                continue;
            }
        }
        return max;
    }
}