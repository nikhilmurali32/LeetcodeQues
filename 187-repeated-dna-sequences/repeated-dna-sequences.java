class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashSet<String> hset = new HashSet<>();
        if(s.length()<10){
            return list;
        }
        String seq="";
        for(int i=0; i<s.length(); i++){
            seq += s.charAt(i);
            if(seq.length()<10){
                continue;
            }
            if(hset.contains(seq)){
                if(!list.contains(seq)){
                    list.add(seq);
                }
            }
            else{
                hset.add(seq);
            }
            seq=seq.substring(1, seq.length());
        }
        return list;
    }
}