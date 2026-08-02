class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int i=1;
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int prev = intervals[0][1];
        int n = intervals.length;
        if(n==1){
            return new int[][]{new int[]{start, prev}};
        }
        while(i<n){
            while(i<n && intervals[i][0]<=prev){
                prev = Math.max(prev, intervals[i][1]);
                i++;
            }
            list.add(new int[]{start, prev});
            if(i==n){
                break;
            }
            start = intervals[i][0];
            prev = intervals[i][1];
        }
        return list.toArray(new int[list.size()][]);
    }
}