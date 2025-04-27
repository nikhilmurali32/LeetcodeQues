class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            String s = timePoints.get(i);
            String[] s_arr = s.split(":");
            String hour = s_arr[0];
            String minutes = s_arr[1];
            int min = (Integer.valueOf(String.valueOf(hour.charAt(0))))*600 + (Integer.valueOf(String.valueOf(hour.charAt(1))))*60 + (Integer.valueOf(String.valueOf(minutes.charAt(0))))*10 + (Integer.valueOf(String.valueOf(minutes.charAt(1))));
            System.out.println(min);
            arr[i]=min;
            System.out.println(arr[i]);
        }
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        for(int j=0; j<arr.length-1; j++){
            ans=Math.min(ans, Math.min(arr[j+1]-arr[j], 1440-arr[j+1]+arr[j]));
        }
        return Math.min(ans, 1440-arr[n-1]+arr[0]);
    }
}