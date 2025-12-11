class Solution {
    public int longestOnes(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int sum=0;
        int i=0, j=0;
        int max=0;
        int count=0;
        while(j<nums.length){
            if(nums[j]==0){
                list.add(j);
                k--;
            }
            if(k>=0){
                count++;
                max=Math.max(max, count);
            }
            else{
                int temp=i;
                while(temp<=list.get(0)){
                    count -= nums[temp];
                    temp++;
                }
                i=list.get(0)+1;
                list.remove(0);
                k++;
            }
            j++;
        }
        return max;
    }
}