class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int[] arr = new int[101];
        Arrays.fill(arr, -1);
        int min=Integer.MAX_VALUE;
        for(int i=0; i<capacity.length; i++){
            if(arr[capacity[i]]==-1){
                arr[capacity[i]] = i;
            }
            if(capacity[i]>=itemSize){
                min=Math.min(min, capacity[i]);
            }
        }
        return min==Integer.MAX_VALUE || arr[min]==-1?-1:arr[min];
    }
}