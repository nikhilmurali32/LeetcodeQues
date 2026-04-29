class MyCalendarThree {
    TreeMap<Integer, Integer> meets;
    public MyCalendarThree() {
        meets = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        meets.put(startTime, meets.getOrDefault(startTime, 0)+1);
        meets.put(endTime, meets.getOrDefault(endTime, 0)-1);
        int bookings=0;
        int maxOverlapBookings=0;
        for(int val:meets.values()){
            bookings += val;
            if(bookings > maxOverlapBookings){
                maxOverlapBookings = bookings;
            }
        }
        return maxOverlapBookings;        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */