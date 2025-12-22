class MedianFinder {
    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> pq_rev;
    public MedianFinder() {
        this.pq = new PriorityQueue<>();
        this.pq_rev = new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        pq_rev.offer(num);
        pq.offer(pq_rev.poll());
        if(pq.size()>pq_rev.size()){
            pq_rev.offer(pq.poll());
        }
    }
    
    public double findMedian() {
        double ans=0;
        int n=pq_rev.size()+pq.size();
        // List<Integer> list = new ArrayList<>();
        // if(pq.peek()==null || pq_rev.peek()==null){
        //     return (double)pq_rev.peek();
        // }
        System.out.println(n);
        if(n%2==0){
            if(pq.peek()==null){
                return (double)pq_rev.peek();
            }
            ans=((double)pq.peek() + (double)pq_rev.peek())/2;
        }
        else{
            ans=(double)pq_rev.peek();
        }
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */