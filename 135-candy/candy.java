class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0; i<n; i++){
            pq.add(new int[]{i, ratings[i]});
        }
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        int count=0;
        while(count!=n){
            int[] pair = pq.poll();
            int minInd=pair[0];
            int leftNei=minInd-1;
            int rightNei=minInd+1;
            if(leftNei>=0){
                if(ratings[leftNei]<ratings[minInd]){
                    candies[minInd] = candies[minInd]<=candies[leftNei]?candies[leftNei]+1:candies[minInd];
                }
                else if(ratings[leftNei]>ratings[minInd]){
                    candies[leftNei] = candies[leftNei]<=candies[minInd]?candies[minInd]+1:candies[leftNei];
                }
            }
            if(rightNei<n){
                if(ratings[rightNei]<ratings[minInd]){
                    candies[minInd] = candies[minInd]<=candies[rightNei]?candies[rightNei]+1:candies[minInd];
                }
                else if(ratings[rightNei]>ratings[minInd]){
                    candies[rightNei] = candies[rightNei]<=candies[minInd]?candies[minInd]+1:candies[rightNei];
                }
            }
            count++;
        }
        int sum=0;
        for(int i=0; i<candies.length; i++){
            sum += candies[i];
        }
        return sum;
    }
}