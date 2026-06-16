class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        for(int i=0; i<s.length(); i++){
            lastPos[s.charAt(i)-'a']=i;
        }
        int i=0, j=0;
        List<Integer> list = new ArrayList<>();
        int farthest = 0;
        while(i<=j && j<s.length()){
            farthest = Math.max(farthest, lastPos[s.charAt(j)-'a']);
            if(farthest==j){
                list.add(j-i+1);
                i=j+1;
                farthest=0;
            }
            j++;
        }
        return list;
    }
}