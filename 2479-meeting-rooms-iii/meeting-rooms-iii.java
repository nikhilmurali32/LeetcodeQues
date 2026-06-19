class Solution {
    class Room{
        int roomNo;
        int startTime;
        long endTime;
        int usedCount;
        Room(int s, long e){
            this.startTime = s;
            this.endTime = e;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->Integer.compare(a[0], b[0]));
        PriorityQueue<Room> roomsinUse = new PriorityQueue<>((a,b) ->a.endTime!=b.endTime?Long.compare(a.endTime, b.endTime):Integer.compare(a.roomNo, b.roomNo));

        PriorityQueue<Room> notusedRooms = new PriorityQueue<>((a,b) -> Integer.compare(a.roomNo, b.roomNo));

        for(int i=0; i<n; i++){
            Room room = new Room(0, 0);
            room.roomNo = i;
            room.usedCount=0;
            notusedRooms.add(room);
        }

        int len=meetings.length;
        int i=0;
        while(i<len){
            while(!roomsinUse.isEmpty() && roomsinUse.peek().endTime<=meetings[i][0]){
                Room room = roomsinUse.remove();
                notusedRooms.add(room);                
            }
            if(!notusedRooms.isEmpty()){
                Room room = notusedRooms.remove();
                room.endTime = (meetings[i][1]);
                room.usedCount++;
                roomsinUse.add(room);
            }
            else{
                Room room = roomsinUse.remove();
                room.endTime += (meetings[i][1]-meetings[i][0]);
                room.usedCount++;
                roomsinUse.add(room);
            }
            i++;            
        }
        PriorityQueue<Room> ans = new PriorityQueue<>((a,b)->a.usedCount!=b.usedCount?Integer.compare(b.usedCount, a.usedCount):Integer.compare(a.roomNo, b.roomNo));
        while(!roomsinUse.isEmpty()){
            ans.add(roomsinUse.remove());
        }
        while(!notusedRooms.isEmpty()){
            ans.add(notusedRooms.remove());
        }
        return ans.peek().roomNo;
    }
}