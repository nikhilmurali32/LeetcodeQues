class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                hmap.put(st.pop(), nums[i]);
            }
            st.push(i);
        }
        int n=nums.length-1;
        while(n>=0 && st.size()>1){
            for(int num: nums){
                while(st.size()>1 && num>nums[st.peek()]){
                    hmap.put(st.pop(), num);
                }
                if(st.size()==1){
                    break;
                }
            }
            if(st.size()==1){
                break;
            }
            n--;
        }
        while(!st.isEmpty()){
            hmap.put(st.pop(), -1);
        }
        for(int i=0; i<nums.length; i++){
            nums[i]=hmap.get(i);
        }
        return nums;
    }
}