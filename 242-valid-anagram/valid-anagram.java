class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2){
            return false;
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char ch:s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        int count=0;
        for(char ch:t.toCharArray()){
            if(!freqMap.containsKey(ch)){
                return false;
            }
            freqMap.put(ch, freqMap.get(ch)-1);
            if(freqMap.get(ch)==0){
                count++;
            }
        }
        return count==freqMap.size();
    }
}