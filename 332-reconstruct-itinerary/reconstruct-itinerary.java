class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        List<String> ans = new LinkedList<>();
        for(List<String> ticket:tickets){
            if(!adjList.containsKey(ticket.get(0))){
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(ticket.get(1));
                adjList.put(ticket.get(0), pq);
            }
            else{
                adjList.get(ticket.get(0)).add(ticket.get(1));
            }
        }
        dfs("JFK", adjList, ans);
        return ans;
    }
    public void dfs(String city, HashMap<String, PriorityQueue<String>> adjList, List<String> list){
        PriorityQueue<String> connectedCities = adjList.get(city);
        while(connectedCities!= null && !connectedCities.isEmpty()){
            dfs(connectedCities.remove(), adjList, list);
        }
        list.addFirst(city);
    }
}