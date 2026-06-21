class Solution {
    class Element{
        int i;
        int j;
        Element( int indexStart, int indexEnd){
            this.i=indexStart;
            this.j = indexEnd;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b)->Double.compare((double)arr[a.i]*arr[b.j],(double)arr[b.i]*arr[a.j]));

        Arrays.sort(arr);
        for (int j = 1; j < arr.length; j++) {
            pq.add(new Element(0, j));
        }
        while(--k>0){
            Element element = pq.remove();
            if(element.i+1<element.j){
                pq.add(new Element(element.i+1, element.j));
            }
        }
        return new int[]{arr[pq.peek().i], arr[pq.peek().j]};        
    }
}