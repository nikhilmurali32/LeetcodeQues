class Bank {
    long[] accBalance;
    public Bank(long[] balance) {
        accBalance = new long[balance.length];
        for(int i=0; i<balance.length; i++){
            accBalance[i] = balance[i];
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1-1 >= accBalance.length || account2-1 >= accBalance.length || accBalance[account1-1]<money){
            return false;
        }
        accBalance[account1-1] -= money;   
        accBalance[account2-1] += money;  
        return true;   
    }
    
    public boolean deposit(int account, long money) {
        if(account-1 >= accBalance.length){
            return false;
        }
        accBalance[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account-1 >= accBalance.length || accBalance[account-1]<money){
            return false;
        }
        accBalance[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */