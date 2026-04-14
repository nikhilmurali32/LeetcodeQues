class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2){
            return false;
        }
        int[] freqArr = new int[26];
        int count=0;
        for(char ch:s.toCharArray()){
            if(freqArr[ch-'a']==0){
                count++;
            }
            freqArr[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            if(freqArr[ch-'a']==0){
                return false;
            }
            freqArr[ch-'a']--;
            if(freqArr[ch-'a']==0){
                count--;
            }
        }
        return count==0;
    }
}