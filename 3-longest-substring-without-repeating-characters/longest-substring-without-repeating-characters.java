class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i=0, j=0, n=s.length();
        if(n==0){
            return 0;
        }
        int max=1;
        while(j<n){
            if(!hmap.containsKey(s.charAt(j))){
                hmap.put(s.charAt(j), j);
            }
            else{
                max=Math.max(max, hmap.size());
                int next_i=hmap.get(s.charAt(j))+1;
                for(int k=i; k<next_i; k++){
                    hmap.remove(s.charAt(k));
                }
                hmap.put(s.charAt(j), j);
                i=next_i;
            }
            j++;
        }
        return Math.max(max, hmap.size());
    }
}