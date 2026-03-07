class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i=0;
        List<Integer> list = new ArrayList<>();
        int j=1;
        while(i<arr.length){
            if(arr[i]!=j){
                list.add(j);
            }
            else{
                i++;
            }
            j++;
        }
        int size=list.size();
        int x=k;
        while(k>size){
            list.add(j);
            j++;
            k--; 
        }
        return list.get(x-1);
    }
}