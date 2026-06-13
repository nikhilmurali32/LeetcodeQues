class Solution {
    class Node{
        int x, y;
        int dist;
        Node(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> closestPoints = new PriorityQueue<>((a,b) -> Integer.compare(b.dist, a.dist));
        for(int[] point:points){
            Node node = new Node(point[0], point[1], point[0]*point[0] + point[1]*point[1]);
            closestPoints.add(node);
            if(closestPoints.size()>k){
                closestPoints.remove();
            }
        }
        int[][] res = new int[k][2];
        int i=0;
        while(!closestPoints.isEmpty() && i<k){
            Node node = closestPoints.remove();
            res[i][0] = node.x;
            res[i][1] = node.y;
            i++;
        }
        return res;
    }
}