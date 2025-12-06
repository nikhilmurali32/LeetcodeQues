class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> dq = new LinkedList<>();
        dq.add(-1);
        int i=0;
        int res=0;
        while(i<nums.length){
            if(nums[i]%2 != 0){
                dq.add(i);
            }
            if(dq.size()>k+1){
                dq.pop();
            }
            if(dq.size()==k+1){
                res += dq.get(1)-dq.get(0);
            }
            i++;
        }
        return res;
    }
}