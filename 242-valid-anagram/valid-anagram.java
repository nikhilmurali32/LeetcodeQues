class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        HashSet<Character> hset = new HashSet<>();
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            hset.add(ch);
            freq[ch-'a']++;
        }
        int count=0;
        for(char ch:t.toCharArray()){
            if(freq[ch-'a']==0){
                return false;
            }
            freq[ch-'a']--;
            if(freq[ch-'a']==0){
                count++;
            }
        }
        return count==hset.size()?true:false;
    }
}