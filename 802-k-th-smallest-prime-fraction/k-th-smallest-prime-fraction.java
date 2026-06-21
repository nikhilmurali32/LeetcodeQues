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
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b)->Double.compare((double)arr[a.i]/arr[a.j],(double)arr[b.i]/arr[b.j]));

        Arrays.sort(arr);
        for (int j = 1; j < arr.length; j++) {
            pq.add(new Element(0, j));
        }
        int[] ans= new int[2];
        while(k>0){
            Element element = pq.remove();
            ans[0]=arr[element.i];
            ans[1]=arr[element.j];
            k--;
            if(element.i+1<element.j){
                pq.add(new Element(element.i+1, element.j));
            }
        }
        return ans;        
    }
}