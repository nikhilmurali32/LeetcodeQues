//try using two heaps
class Solution {
class Node{
    int val;
    int ind;
    int count;
    Node(int val, int ind, int count){
        this.val=val;
        this.ind=ind;
        this.count=count;
    }
}
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Node> freeServers = new PriorityQueue<>((a,b) -> a.val==b.val?a.ind-b.ind:a.val-b.val);
        for(int i=0; i<servers.length; i++){
            freeServers.add(new Node(servers[i],i, 0));
        }
        PriorityQueue<Node> usedQueue = new PriorityQueue<>((a,b) -> a.count==b.count?a.val==b.val?a.ind-b.ind:a.val-b.val:a.count-b.count);
        int[] ans = new int[tasks.length];
        for(int i=0; i<tasks.length; i++){
            int t=tasks[i];
            while(!usedQueue.isEmpty() && usedQueue.peek().count<=i){
                freeServers.add(usedQueue.poll());
            }
            if(freeServers.isEmpty()){
                Node node=usedQueue.poll();
                node.count = node.count+t;
                ans[i]=node.ind;
                usedQueue.add(node);
            }
            else{
                Node freeNode = freeServers.poll();
                freeNode.count=i+t;
                ans[i]=freeNode.ind;
                usedQueue.add(freeNode);
            }
        }
        return ans;
    }
}