class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> largestStones = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int stone:stones){
            largestStones.add(stone);
        }
        while(largestStones.size()>1){
            int first = largestStones.remove();
            int second = largestStones.remove();
            if(first!=second){
                largestStones.add(first-second);
            }
        }
        return largestStones.isEmpty()?0:largestStones.remove();
    }
}