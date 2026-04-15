class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length(), n=s2.length();
        if(m>n){
            return false;
        }
        int[] freqMaps1 = new int[26];
        for(char ch:s1.toCharArray()){
            freqMaps1[ch-'a']++;
        }
        int[] freqMaps2 = new int[26];
        int i=0, j=0;
        while(i<=j && j<n){
            char ch=s2.charAt(j);
            freqMaps2[ch-'a']++;
            if(j-i+1 < m){
                j++;                
                continue;
            }            
            if(Arrays.equals(freqMaps1, freqMaps2)){
                return true;
            }
            freqMaps2[s2.charAt(i)-'a']--;
            i++;
            j++;
        }
        return false;
    }
}