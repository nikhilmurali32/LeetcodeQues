class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        HashSet<Character> hset = new HashSet<>();
        for(char ch :s1.toCharArray()){
            freq[ch-'a']++;
            hset.add(ch);
        }
        int count=hset.size();
        int i=0, j=0;
        while(j<s2.length()){
            char ch=s2.charAt(j);
            if(hset.contains(ch)){
                freq[ch-'a']--;
                if(freq[ch-'a']==0){
                    count--;
                }                
            }

            while(count==0){
                char c=s2.charAt(i);
                if(hset.contains(c)){
                    freq[c-'a']++;
                    if(freq[c-'a']>0){
                        count++;
                    }
                }
                if(j-i+1==s1.length()){
                    return true;
                }
                i++;
            }
            j++;
        }
        return false;
    }
}