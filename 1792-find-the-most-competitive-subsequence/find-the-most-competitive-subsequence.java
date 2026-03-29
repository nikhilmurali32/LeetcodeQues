class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> compSubs = new ArrayDeque<>();
        int i=0;
        int j=0;
        int n=nums.length;
        int[] res = new int[k];
        while(i<n){
            while(!compSubs.isEmpty() && nums[i]<nums[compSubs.peekLast()]){
                compSubs.removeLast();
            }
            compSubs.addLast(i);
            if(i==n-k+j){
                res[j]=nums[compSubs.removeFirst()];
                j++;
            }
            i++;
        }
        return res;
    }
}