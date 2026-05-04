class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        List<String> finalItenary = new LinkedList<>();
        for(List<String> ticket:tickets){
            if(!adjList.containsKey(ticket.get(0))){
                adjList.put(ticket.get(0), new PriorityQueue<>());
            }
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK", adjList, finalItenary);
        return finalItenary;
    }
    public void dfs(String src, HashMap<String, PriorityQueue<String>> adjList, List<String> finalItenary){
        PriorityQueue<String> connectedCities = adjList.get(src);
        while(connectedCities != null && !connectedCities.isEmpty()){
            dfs(connectedCities.remove(), adjList, finalItenary);
        }
        finalItenary.addFirst(src);
    }
}