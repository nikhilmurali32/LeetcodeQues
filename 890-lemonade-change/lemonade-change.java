class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[3];
        for(int i=0; i<bills.length; i++){
            int curr=bills[i]-5;
            if(curr==5){
                if(cash[0]==0){
                    return false;
                }
                else{
                    cash[0]--;
                }
            }
            else if(curr==15){
                if(cash[1]==0){
                    if(cash[0]<3){
                        return false;
                    }
                    else{
                        cash[0] -= 3;
                    }
                }
                else if(cash[1]>0){
                    cash[1]--;
                    if(cash[0]==0){
                        return false;
                    }
                    else{
                        cash[0]--;
                    }
                }
            }
            if(bills[i]==5){
                cash[0]++;
            }
            else if(bills[i]==10){
                cash[1]++;
            }
            else{
                cash[2]++;
            }
        }
        return true;
    }
}