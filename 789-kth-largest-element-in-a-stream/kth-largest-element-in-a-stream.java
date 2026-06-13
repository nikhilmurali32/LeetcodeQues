class KthLargest {
    PriorityQueue<Integer> scores;
    int i;
    public KthLargest(int k, int[] nums) {
        scores = new PriorityQueue<>();
        i=k;
        for(int num:nums){
            scores.add(num);
        }
    }
    
    public int add(int val) {
        scores.add(val);
        while(scores.size()>i){
            scores.remove();
        }
        return scores.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */