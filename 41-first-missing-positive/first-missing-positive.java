class Solution {
    public int firstMissingPositive(int[] nums) {
        long sum=0;
        HashSet<Long> hset = new HashSet<>();
        for(int num:nums){
            if(num>0 && !hset.contains((long)num)){
                sum+=(long)num;
                hset.add((long)num);
            }
        }
        long n=hset.size();
        long tot=n*(n+1)/2;
        if(tot>sum){
            return (int)(tot-sum);
        }
        else if(tot==sum){
            return (int)(n+1);
        }
        for(long i=1; i<=n; i++){
            if(!hset.contains(i)){
                return (int)i;
            }
        }
        return -1;
    }
}