class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashSet<Character> hset = new HashSet<>();
        int max=1;
        int start=0;
        for(char ch:s.toCharArray()){
            if(!hset.add(ch)){
                char dup = ch;
                while(s.charAt(start)!=dup){
                    hset.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            max=Math.max(max, hset.size());
        }
        return max;
    }
}