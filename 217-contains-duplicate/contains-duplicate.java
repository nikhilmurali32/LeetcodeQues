class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueVal = new HashSet<>();
        for(int num:nums){
            if(!uniqueVal.add(num)){
                return true;
            }
        }
        return false;
    }
}