class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> distinct = new HashSet<>();
        for(int num:nums){
            distinct.add(num);
        }
        int max=0;
        for(int num:distinct){
            if(!distinct.contains(num-1)){
                int count=1;
                while(distinct.contains(num+1)){
                    count++;
                    num++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}