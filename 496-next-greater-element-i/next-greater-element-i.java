class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num:nums2){
            while(!st.isEmpty() && st.peek()<num){
                hmap.put(st.pop(), num);
            }
            st.push(num);
        }
        for(int i=0; i<nums1.length; i++){
            nums1[i]=hmap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}