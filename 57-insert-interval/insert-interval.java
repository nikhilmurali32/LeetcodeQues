class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean merged=false;
        for(int[] interval:intervals){
            if(!merged){
                if(newInterval[0]>=interval[0] && newInterval[1]<=interval[1]){
                    list.add(interval);
                    merged=true;
                    continue;
                }
                else if(newInterval[0]<interval[0] && newInterval[1]<interval[0]){
                    list.add(newInterval);
                    list.add(interval);
                    merged=true;
                    continue;
                }
                if(interval[1]<newInterval[0]){
                    list.add(interval);
                }
                else{
                    list.add(new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])});
                    merged=true;
                }
            }
            else{
                int[] lastInt = list.get(list.size()-1);
                if(lastInt[0]<=interval[0] && lastInt[1]>=interval[1]){
                    continue;
                }
                if(interval[0]>lastInt[1]){
                    list.add(interval);
                }
                else{
                    list.add(new int[]{Math.min(interval[0], lastInt[0]), Math.max(interval[1], lastInt[1])});
                    list.remove(list.size()-2);
                }                
            }

        }
        if(list.size()==0 || !merged){
            list.add(newInterval);
        }
        int[][] res = new int[list.size()][2];
        for(int i=0; i<res.length; i++){
            res[i]=list.get(i);
        }
        return res;
    }
}