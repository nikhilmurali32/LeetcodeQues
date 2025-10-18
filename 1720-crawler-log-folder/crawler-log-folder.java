class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        for(String log:logs){
            if(log.equals("../")){
                if(count==0){
                    continue;
                }
                count--;
            }
            else if(log.equals("./")){
                continue;
            }
            else{
                count++;
            }
        }
        return count<0? 0:count;
    }
}