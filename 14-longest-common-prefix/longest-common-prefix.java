class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first=strs[0], last = strs[strs.length-1];
        int size=Math.min(first.length(), last.length());
        int i=0;
        int count=0;
        while(i<size){
            if(first.charAt(i)!=last.charAt(i)){
                break;
            }
            count++;
            i++;
        }
        return first.substring(0, count);
    }
}