class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
                hmap.put(nums2[st.pop()], nums2[i]);
            }
            st.push(i);
        }
        for(int i=0; i<nums1.length; i++){
            nums1[i]=hmap.get(nums1[i])==null?-1:hmap.get(nums1[i]);
        }
        return nums1;
    }
}