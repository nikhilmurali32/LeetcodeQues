class Solution {
    //[0,6], [0,0], [1,8], []
    // [0,2], [1,9], [1,5], [4,6], [5,9], [8, 10]
    //[8,16], [8,10], [11,19], [13,35], [17,39], [18,35], [18,19], [33,39] , 20
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b) -> a[0]!=b[0] ? Integer.compare(a[0], b[0]): Integer.compare(b[1], a[1]));
        int currStart = clips[0][0], currEnd = clips[0][1], nextEnd=currEnd;
        if(currStart>0){
            return -1;
        }
        int count=1;
        int i=0; 
        while(i<clips.length){
            if(currEnd>=time){
                return count;
            }
            if(clips[i][0] > currEnd){
                return -1;
            }
            nextEnd = currEnd;
            while(i<clips.length && clips[i][0]<=currEnd){
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            count++;
            currEnd = nextEnd;
        }
        return currEnd>=time?count:-1;
    }
}