class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(j>=0 && i>=0){
            if(nums2[j]>nums1[i]){
                nums1[k]=nums2[j];
                j--;
                k--;
            }
            else{
                nums1[k]=nums1[i];
                i--;
                k--;
            }
        }
        if(j>=0){
            while(j>=0){
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }
    }
}