class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(k<arr[0]){
            return k;
        }
        int l=0, r=arr.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(k>arr[mid]-(mid+1)){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        l--;
        if(l==-1){
            return arr[l+1]<=k?k+1:k;
        }
        k=k-(arr[l]-(l+1));
        System.out.println(k);
        int i=arr[l]+1;
        System.out.println(i);
        System.out.println(r);
        while(k>0){
            if(r<arr.length && arr[r]==i){
                r++;
                i++;
                // k--;
                continue;
            }
            i++;
            k--;
        }
        return i-1;
    }
}