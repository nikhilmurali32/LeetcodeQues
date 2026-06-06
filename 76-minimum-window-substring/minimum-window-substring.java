class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> uniqueS = new HashMap<>();
        for(char ch:t.toCharArray()){
            uniqueS.put(ch, uniqueS.getOrDefault(ch, 0)+1);
        }
        int count=uniqueS.size();
        int i=0, j=0, n=s.length();
        int startInd= 0;
        int minLen = Integer.MAX_VALUE;
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
                        startInd=i;
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
        return minLen==Integer.MAX_VALUE?"":s.substring(startInd, startInd+minLen);
    }
}