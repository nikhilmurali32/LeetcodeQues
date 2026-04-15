class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        if(n==0){
            return 0;
        }
        int[] freq = new int[26];
        int i=0, j=0, maxFreq=0, maxLen=1;
        while(i<=j && j<n){
            freq[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j)-'A']);
            while((j-i+1)-maxFreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
                maxFreq=0;
                for(int f=0; f<26; f++){
                    maxFreq = Math.max(maxFreq, freq[f]);
                }
            }
            maxLen = Math.max(maxLen, (j-i+1));
            j++;
        }
        return maxLen;
    }
}