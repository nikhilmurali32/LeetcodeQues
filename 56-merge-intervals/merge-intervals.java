class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int start=intervals[0][0], end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int[] interval:intervals){
            if(interval[0]<=end){
                end = Math.max(end, interval[1]);
            }
            else{
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        int[][] ans = new int[res.size()][2];
        for(int i=0; i<ans.length; i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
}