class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                hmap.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++){
            nums1[i]=hmap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}