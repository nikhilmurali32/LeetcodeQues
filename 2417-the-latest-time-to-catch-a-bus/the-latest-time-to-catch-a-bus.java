class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int m=buses.length, n=passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j=0, res=1;
        for(int i=0; i<m; i++){
            int count=capacity;
            while(j<n && passengers[j]<=buses[i] && count>0){
                if(j==0){
                    res = passengers[j]-1;
                }
                if(j>0 && passengers[j-1] != passengers[j]-1){
                    res = passengers[j]-1;
                }
                j++;
                count--;
            }
            if(count>0){
                int k=j-1;
                int time = buses[i];
                while(k>=0 && passengers[k]==time){
                    k--;
                    time--;
                }
                res=time;
                count--;
            }
        }
        return res;
    }
}