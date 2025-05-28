class Solution {
    int mod = 1000000007;
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count=0;
        for(int num: deliciousness){
            int power=1;
            for(int i=0; i<22; i++){
                if(hmap.containsKey(power-num)){
                    count += hmap.get(power-num);
                    count %= mod;
                }
                power *= 2;
            }
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }
        return count;
    }
}