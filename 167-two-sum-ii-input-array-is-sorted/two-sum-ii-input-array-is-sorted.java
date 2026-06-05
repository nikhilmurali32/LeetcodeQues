class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        for(int i=0; i<n; i++){
            int l=i+1, r=n-1;
            while(l<r){
                int mid = l+ (r-l)/2;
                if(numbers[mid] < target-numbers[i]){
                    l=mid+1;
                }
                else{
                    r=mid;
                }
            }
            if(numbers[i]+numbers[l] == target){
                return new int[]{i+1, l+1};
            }
        }
        return new int[]{0,0};
    }
}