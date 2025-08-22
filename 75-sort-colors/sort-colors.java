class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num:nums){
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }
        int num_zeros = 0;
        int num_ones = 0;
        int num_twos = 0;
        if(hmap.containsKey(0)){
            num_zeros = hmap.get(0);
        }
        if(hmap.containsKey(1)){
            num_ones = hmap.get(1);
        }
        if(hmap.containsKey(2)){
            num_twos = hmap.get(2);
        }
        int i=0;
        while(i<num_zeros){
            nums[i]=0;
            i++;
        }
        while(i<num_ones+num_zeros){
            nums[i]=1;
            i++;
        }
        while(i<num_twos+num_ones+num_zeros){
            nums[i]=2;
            i++;
        }
    }
}