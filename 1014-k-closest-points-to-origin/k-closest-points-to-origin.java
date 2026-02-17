class Node{
    int[] point;
    int dist;
    Node(int[] point, int dist){
        this.point=point;
        this.dist=dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {

PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
for(int[] point:points){
    int dist = (int)Math.pow(point[0],2)+ (int)Math.pow(point[1],2);
    Node node = new Node(point, dist);
    pq.add(node); 
}
int[][] res = new int[k][2];
while(k>0){
    Node n = pq.poll();
    res[k-1][0] = n.point[0];
    res[k-1][1] = n.point[1];
    k--;
}
return res;
    }
}