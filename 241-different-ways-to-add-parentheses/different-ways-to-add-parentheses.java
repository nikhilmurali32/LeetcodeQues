class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int n=expression.length();
        for(int i=0; i<n; i++){
            char ch = expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                List<Integer> l1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> l2 = diffWaysToCompute(expression.substring(i+1, n));
                for(int j=0; j<l1.size(); j++){
                    for(int k=0; k<l2.size(); k++){
                        if(ch=='+'){
                            res.add(l1.get(j)+l2.get(k));
                        }
                        else if(ch=='-'){
                            res.add(l1.get(j)-l2.get(k));
                        }
                        else{
                            res.add(l1.get(j)*l2.get(k));
                        }
                    }
                }
            }
        }
        if(res.size()==0){
            res.add(Integer.valueOf(expression)); 
        }
        return res;
    }
}