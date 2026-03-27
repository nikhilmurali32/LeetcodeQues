class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch :s1.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        int i=0, j=0, count=freq.size();
        while(j<s2.length()){
            char ch=s2.charAt(j);
            if(freq.containsKey(ch)){
                freq.put(ch, freq.get(ch)-1);
                if(freq.get(ch)==0){
                    count--;
                }                
            }

            while(count==0){
                char c=s2.charAt(i);
                if(freq.containsKey(c)){
                    freq.put(c, freq.get(c)+1);
                    if(freq.get(c)>0){
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