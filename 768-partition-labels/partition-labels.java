class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] rightmostIndex = new int[26];
        int n=s.length();
        for(int i=0; i<n; i++){
            rightmostIndex[s.charAt(i)-'a'] = i;
        }
        int maxRight = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            maxRight = Math.max(maxRight, rightmostIndex[ch-'a']);
            sb.append(ch);
            if(i==maxRight){
                list.add(sb.length());
                sb.setLength(0);
                maxRight=0;
            }
        }
        return list;
    }
}