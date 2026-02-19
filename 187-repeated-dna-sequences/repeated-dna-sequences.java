class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hset_list = new HashSet<>();
        HashSet<String> hset = new HashSet<>();
        if(s.length()<10){
            return new ArrayList<>();
        }
        String seq="";
        for(int i=0; i<s.length(); i++){
            seq += s.charAt(i);
            if(seq.length()<10){
                continue;
            }
            if(hset.contains(seq)){
                if(!hset_list.contains(seq)){
                    hset_list.add(seq);
                }
            }
            else{
                hset.add(seq);
            }
            seq=seq.substring(1, seq.length());
        }
        List<String> list = new ArrayList<>(hset_list);
        return list;
    }
}