class Solution {
    static class Node{
        int last;
        int len;
        Node(int last, int len){
            this.last=last;
            this.len=len;   
        }
    }
    public boolean isPossible(int[] nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.last==b.last?a.len-b.len:a.last-b.last));
        for(int num:nums){
            while (!pq.isEmpty() && pq.peek().last < num - 1) {
                if (pq.poll().len < 3) return false;
            }
            if(!pq.isEmpty() && pq.peek().last==num-1){
                Node cur = pq.poll();
                pq.offer(new Node(num, cur.len+1));
            }
            else{
                pq.offer(new Node(num, 1));
            }
        }
        while(!pq.isEmpty()){
            if(pq.poll().len<3){
                return false;
            }
        }
        return true;
    }
}