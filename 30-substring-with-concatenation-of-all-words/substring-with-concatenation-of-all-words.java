class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for(String word:words){
            hmap.put(word, hmap.getOrDefault(word, 0)+1);
        }
        int wordLen=words[0].length();
        int totLen = wordLen*words.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<wordLen; i++){
            int left=i;
            int count=0;
            HashMap<String, Integer> seen = new HashMap<>();
            for(int j=i; j+wordLen<=s.length(); j=j+wordLen){
                String temp=s.substring(j, j+wordLen);
                if(hmap.containsKey(temp)){
                    seen.put(temp, seen.getOrDefault(temp, 0)+1);
                    count++;
                    while(seen.get(temp)>hmap.get(temp)){
                        String str=s.substring(left, left+wordLen);
                        seen.put(str, seen.get(str)-1);
                        count--;
                        left += wordLen;
                    }
                    if(count==words.length){
                        res.add(left);
                    }

                }
                else{
                    seen.clear();
                    left = j+wordLen;
                    count=0;
                }
            }
        }
        return res;
    }
}