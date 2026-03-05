class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] arr = new int[tasks.length][3];
        for(int i=0; i<tasks.length; i++){
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr, (a,b)->a[0]!=b[0]?a[0]-b[0]:a[2]-b[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]!=b[1]?a[1]-b[1]:a[2]-b[2]);
        long currTime=0;
        int i=0, j=0;
        int[] ans = new int[tasks.length];
        while(i<tasks.length){
            if(pq.isEmpty() && currTime<arr[i][0]){
                currTime = arr[i][0];
            }
            while(j<tasks.length && arr[j][0]<=currTime){
                pq.add(arr[j]);
                j++;
            }
            int[] t=pq.poll();
            ans[i]=t[2];
            currTime += t[1];
            i++;
        }
        return ans;
    }
}