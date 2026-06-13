class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int num:nums){
            maxHeap.add(num);
            if(maxHeap.size()>n-k+1){
                maxHeap.remove();
            }
        }
        return maxHeap.peek();
    }
}