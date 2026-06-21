class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int n1=nums1.length, n2=nums2.length;
        List<List<Integer>> list = new ArrayList<>();
        if(k<=0 || (n1==0 && n2==0)){
            return list;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(nums1[a[0]]+nums2[a[1]], nums1[b[0]]+nums2[b[1]]));
        for(int i=0; i<n1; i++){
            pq.add(new int[]{i, 0});
        }
        
        while(k>0){
            int[] pair = pq.remove();
            list.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            k--;
            if(pair[1]+1<n2){
                pq.add(new int[]{pair[0], pair[1]+1});
            }
        }
        return list;
    }
}