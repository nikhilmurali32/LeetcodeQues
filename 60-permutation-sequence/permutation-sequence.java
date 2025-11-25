class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++){
            nums.add(i);
        }
        int[] fact = new int[n];
        fact[0]=1;
        for(int i=1; i<n; i++){
            fact[i]=i*fact[i-1];
        }
        k--;
        String str="";
        for(int i=n; i>0; i--){
            int idx=k/fact[i-1];
            str += String.valueOf(nums.get(idx));
            nums.remove(idx);
            k = k%fact[i-1];
        }
        return str;
    }
}