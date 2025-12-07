class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        return atmostk(s, 3) - atmostk(s, 2);
    }
    public int atmostk(String s, int k){
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i=0, j=0;
        int res=0;
        while(j<s.length()){
            hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j),0)+1);
            if(hmap.get(s.charAt(j))==1){
                k--;
            }
            while(k<0){
                if(hmap.get(s.charAt(i))>1){
                    hmap.put(s.charAt(i), hmap.get(s.charAt(i))-1);
                }
                else if(hmap.get(s.charAt(i))==1){
                    hmap.put(s.charAt(i), hmap.get(s.charAt(i))-1);
                    k++;
                }
                i++;
            }
            res += (j-i+1);
            j++;
        }
        return res;
    }
}