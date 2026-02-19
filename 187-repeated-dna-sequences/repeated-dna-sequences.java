class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hset_list = new HashSet<>();
        HashSet<String> hset = new HashSet<>();
        if(s.length()<10){
            return new ArrayList<>();
        }
        String seq="";
        for(int i=0; i<s.length()-9; i++){
            seq=s.substring(i, i+10);
            if(!hset.add(seq)){
                hset_list.add(seq);
            }
        }
        List<String> list = new ArrayList<>(hset_list);
        return list;
    }
}