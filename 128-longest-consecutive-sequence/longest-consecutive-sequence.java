class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> distinct = new HashSet<>();
        for(int num:nums){
            distinct.add(num);
        }
        int max=0;
        for(int num:nums){
            if(distinct.contains(num) && !distinct.contains(num-1)){
                int count=1;
                distinct.remove(num);
                while(distinct.contains(num+1)){
                    count++;
                    num++;
                    distinct.remove(num);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}