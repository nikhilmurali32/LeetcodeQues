class Solution {
    public int longestOnes(int[] nums, int k) {
        int count=0;
        int i=0, j=0;
        int max=0;
        while(j<nums.length){
            if(nums[j]==0){
                k--;
                if(k<0){
                    while(i<=j && k<0){
                        if(nums[i]==0){
                            k++;
                        }
                        i++;
                    }
                }
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}