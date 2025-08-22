class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;

        int[] copy = nums.clone();
        Arrays.sort(copy);
        int med = copy[n/2];

        java.util.function.IntUnaryOperator map = i -> (1 + 2 * i) % (n | 1);

        int i=0, j=0, k=n-1;
        
        while(j<=k){
            if(nums[map.applyAsInt(j)]>med){
                swap(nums, map.applyAsInt(j), map.applyAsInt(i));
                i++;
                j++;
            }
            else if(nums[map.applyAsInt(j)]<med){
                swap(nums, map.applyAsInt(j), map.applyAsInt(k));
                k--;
            }
            else{
                j++;
            }
        }

    }
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}