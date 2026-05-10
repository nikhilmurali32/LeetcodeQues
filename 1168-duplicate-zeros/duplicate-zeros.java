class Solution {
    public void duplicateZeros(int[] arr) {
        int i=arr.length-1;
        int countZero=0;
        for(int elem:arr){
            if(elem==0){
                countZero++;
            }
        }
        int j = i+countZero;
        while(i>=0 && j>=0){
            if(arr[i]==0){
                if(j<arr.length){
                    arr[j]=0;
                }
                j--;
                if(j<arr.length){
                    arr[j]=0;
                }
            }
            else if(j<arr.length){
                arr[j]=arr[i];
            }
            j--;
            i--;
        }
    }
}