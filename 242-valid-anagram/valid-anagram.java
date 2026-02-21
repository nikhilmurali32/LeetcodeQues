class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char ch:s.toCharArray()){
            hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
        }
        int count=0;
        for(char ch:t.toCharArray()){
            if(!hmap.containsKey(ch)){
                return false;
            }
            hmap.put(ch, hmap.get(ch)-1);
            if(hmap.get(ch)<0){
                return false;
            }
            if(hmap.get(ch)==0){
                count++;
            }
        }
        return count==hmap.size()?true:false;
    }
}