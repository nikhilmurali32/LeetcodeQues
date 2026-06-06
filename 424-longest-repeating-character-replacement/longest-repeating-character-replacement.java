class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int n=s.length();
        int maxFreq = 0;
        int i=0, j=0;
        int max=0;
        while(j<n){
            freq[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j)-'A']);
            while((j-i-maxFreq+1)>k){
                freq[s.charAt(i)-'A']--;
                maxFreq=0;
                for(int l=0; l<26; l++){
                    maxFreq = Math.max(maxFreq, freq[l]);
                }
                i++;    
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}