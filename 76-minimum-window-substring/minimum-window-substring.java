class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> uniqueS = new HashMap<>();
        HashSet<Character> hset = new HashSet<>();
        for(char ch:t.toCharArray()){
            uniqueS.put(ch, uniqueS.getOrDefault(ch, 0)+1);
            hset.add(ch);
        }
        int count=hset.size();
        int i=0, j=0, n=s.length();
        String res= "";
        int minLen = n+1;
        while(i<=j && j<n){
            char ch = s.charAt(j);
            if(uniqueS.containsKey(ch)){
                uniqueS.put(ch, uniqueS.getOrDefault(ch, 0) - 1);
                if(uniqueS.get(ch)==0){
                    count--;
                }
                while(count==0){
                    if((j-i+1)<minLen){
                        minLen = j-i+1;
                        res = s.substring(i, j+1);
                    }
                    char leftChar = s.charAt(i);
                    if(uniqueS.containsKey(leftChar)){
                        uniqueS.put(leftChar, uniqueS.get(leftChar) + 1);
                        if(uniqueS.get(leftChar)>0){
                            count++;
                        }
                    }
                    i++;                    
                }
            }
            j++;
        }
        return res;
    }
}