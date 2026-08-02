class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int[] arr = new int[2];
        boolean merged=false, added=false;
        int count=0;
        for(int[] interval:intervals){
            if(merged){
                if(added){
                    if(arr[1]<interval[0]){
                        list.add(new int[]{arr[0], arr[1]});
                        added=false;
                    }
                    else{
                        arr[1] = Math.max(arr[1], interval[1]);
                        count++;
                        continue;
                    }
                }
                list.add(interval);
                count++;
                continue;
            }
            if(newInterval[0]>interval[1]){
                list.add(interval);
                count++;
                continue;
            }
            if(newInterval[0]>=interval[0] && newInterval[1]<=interval[1]){
                list.add(interval);
                merged=true;
                count++;
                continue;
            }
            else if(newInterval[1]<interval[0]){
                list.add(newInterval);
                list.add(interval);
                merged=true;
                count++;
                continue;
            }
            else{
                arr[0] = Math.min(interval[0], newInterval[0]);
                arr[1] = Math.max(newInterval[1], interval[1]);
                merged=true;
                added=true;
                count++;
            }
        }
        if(added){
            list.add(arr);
        }
        if(!merged){
            list.add(newInterval);
        }
        int[][] res = list.toArray(new int[list.size()][]);
        return res;
    }
}