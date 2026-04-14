class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int l=0, r=n-1;
        int[] indices = new int[2];
        while(l<r){
            int currSum = numbers[l]+numbers[r];
            if(currSum==target){
                indices[0] = l+1;
                indices[1] = r+1;
                break;
            }
            else if(currSum<target){
                l++;
            }
            else{
                r--;
            }
        }
        return indices;
    }
}