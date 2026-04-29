class MyCalendarTwo {
    TreeMap<Integer, Integer> meets;
    public MyCalendarTwo() {
        meets = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        meets.put(startTime, meets.getOrDefault(startTime, 0)+1);
        meets.put(endTime, meets.getOrDefault(endTime, 0)-1);
        int bookings=0;
        for(int val:meets.values()){
            bookings += val;
            if(bookings>2){
                meets.put(startTime, meets.get(startTime)-1);
                if(meets.get(startTime)==0){
                    meets.remove(startTime);
                }
                meets.put(endTime, meets.get(endTime)+1);
                if(meets.get(endTime)==0){
                    meets.remove(endTime);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */