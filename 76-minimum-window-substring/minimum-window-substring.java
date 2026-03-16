class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hmap_t = new HashMap<>();
        for(char ch:t.toCharArray()){
            hmap_t.put(ch, hmap_t.getOrDefault(ch,0)+1);
        }
        int count = hmap_t.size();
        int i=0, j=0;
        int min=Integer.MAX_VALUE;
        int startInd=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(hmap_t.containsKey(ch)){
                hmap_t.put(ch, hmap_t.get(ch)-1);
                if(hmap_t.get(ch)==0){
                    count--;
                }
            }
            j++;
            while(count==0){
                if((j-i)<min){
                    min=j-i;
                    startInd=i;
                }
                char start=s.charAt(i);
                if(hmap_t.containsKey(start)){
                    hmap_t.put(start, hmap_t.get(start)+1);
                    if(hmap_t.get(start)>0){
                        count++;
                    }
                }
                i++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startInd, startInd+min);
    }
}