class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0){
            return false;
        }
        int totalGroups = n/groupSize;
        Arrays.sort(hand);
        boolean[] visited = new boolean[n];

        while(totalGroups>0){
            int prev=-1;
            int x=0;
            for(int i=0; i<n && x<groupSize; i++){
                if(visited[i]){
                    continue;
                }
                if(i>0 && hand[i]==prev){
                    continue;
                }
                visited[i]=true;
                x++;
                if(i!=0 && prev!=-1 && hand[i] != prev+1){
                    return false;
                }
                prev=hand[i];
            }
            if(x<groupSize){
                return false;
            }
            totalGroups--;
        }
        return true;
    }
}