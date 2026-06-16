class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[1], b[1]));
        int i=1;
        int n=points.length;
        int currEnd = points[0][1];
        int count=1;
        while(i<n){
            while(i<n && points[i][0]<=currEnd){
                i++;
            }
            if(i==n){
                break;
            }
            count++;
            currEnd = points[i][1];
        }
        return count;
    }
}