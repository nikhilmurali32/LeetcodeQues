class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> dq= new ArrayDeque<>();
        int i=0;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        while(true){
            if(i>nums.length-1){
                i=i%nums.length;
            }
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                res[dq.removeLast()]=nums[i];
            }
            if(!dq.isEmpty() && dq.peekFirst()==i){
                res[dq.removeFirst()]=-1;
                break;
            }
            dq.addLast(i%nums.length);
            i++;
        }
        return res;
    }
}