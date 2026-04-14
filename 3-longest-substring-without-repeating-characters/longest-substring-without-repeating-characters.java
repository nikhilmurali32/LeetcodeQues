class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0){
            return 0;
        }
        HashSet<Character> uniqueChar = new HashSet<>();
        int i=0, j=0;
        int maxLen = 1;
        while(i<=j && j<n){
            if(!uniqueChar.add(s.charAt(j))){
                maxLen = Math.max(maxLen, j-i);
                char repeat = s.charAt(j);
                while(i<n && s.charAt(i) != repeat){
                    uniqueChar.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            j++;
        }
        return Math.max(maxLen, j-i);
    }
}