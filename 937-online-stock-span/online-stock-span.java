class StockSpanner {
List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        if(list.isEmpty()){
            list.add(price);
            return 1;
        }
        int i=list.size()-1;
        int count=1;
        while(i>=0 && list.get(i)<=price){
            count++;
            i--;
        }
        list.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */