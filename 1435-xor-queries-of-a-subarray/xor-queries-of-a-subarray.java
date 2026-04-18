class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] arr1 = new int[arr.length];
        arr1[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            arr1[i] = arr1[i-1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            ans[i] = arr1[queries[i][0]]^arr1[queries[i][1]]^arr[queries[i][0]];
        }
        return ans;
    }
}