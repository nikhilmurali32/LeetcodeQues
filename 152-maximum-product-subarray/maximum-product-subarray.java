class Solution {
    public int maxProduct(int[] nums) {
        int prod=1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            prod *= num;
            if(prod<0){
                if(!pq.isEmpty()){
                    int top=pq.peek();
                    max = Math.max(max, (int)prod/top);
                    continue;
                }
                pq.offer(prod);
                max = Math.max(max, prod);
            }
            else if(prod==0){
                max=Math.max(max, prod);
                pq.clear();
                prod=1;
                continue;
            }
            else{
                max=Math.max(max, prod);
            }
        }
        return max;
    }
}