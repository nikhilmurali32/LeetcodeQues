class MedianFinder {
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;
    public MedianFinder() {
        leftHalf = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftHalf.add(num);
        if(rightHalf.size()<leftHalf.size()){
            rightHalf.add(leftHalf.remove());
        }
        else{
            leftHalf.add(rightHalf.remove());
            rightHalf.add(leftHalf.remove());
        }
    }
    
    public double findMedian() {
        int size = leftHalf.size()+rightHalf.size();
        if(size%2==0){
            double sum = leftHalf.peek()+rightHalf.peek();
            return sum/2;
        }
        return (double)rightHalf.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */