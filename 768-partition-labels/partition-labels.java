class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int i=0, j=0;
        int count=0;
        List<Integer> list = new ArrayList<>();
        HashSet<Character> hset = new HashSet<>();
        while(i<=j && j<s.length()){
            freq[s.charAt(j)-'a']--;
            if(hset.add(s.charAt(j))){
                count += freq[s.charAt(j)-'a'];
            }
            else{
                count--;
            }
            if(count==0){
                list.add(j-i+1);
                i=j+1;
                hset.clear();
            }
            j++;
        }
        return list;
    }
}