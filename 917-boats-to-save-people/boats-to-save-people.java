class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0;
        int r=people.length-1;
        int count=0;
        while(l<r){
            int sum=people[l]+people[r];
            if(sum<=limit){
                count++;
                l++;
                r--;
            }
            else{
                count++;
                r--;
            }
        }
        return l==r ? count+1:count;
    }
}