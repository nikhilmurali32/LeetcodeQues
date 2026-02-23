class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        if(n==0){
            return list;
        }
        helper("", n, n, 0, n);
        return list;
    }
    public void helper(String str, int nOpen, int nClose, int n, int org){
        if(n==2*org){
            list.add(str);
            return;
        }
        if(nOpen>0){
            helper(str+"(", nOpen-1, nClose, n+1, org);
        }
        if(nClose>nOpen){
            helper(str+")", nOpen, nClose-1, n+1, org);
        }
    }
}