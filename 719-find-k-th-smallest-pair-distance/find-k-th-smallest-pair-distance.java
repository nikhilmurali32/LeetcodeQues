class Solution {
    // class Element{
    //     int diff;
    //     int indexStart;
    //     int indexEnd;
    //     Element(int diff, int indexStart, int indexEnd){
    //         this.diff=diff;
    //         this.indexStart=indexStart;
    //         this.indexEnd = indexEnd;
    //     }
    // }
    public int smallestDistancePair(int[] nums, int k) {
        // PriorityQueue<Element> pq = new PriorityQueue<>((a,b)->Integer.compare(a.diff,b.diff));
        // Arrays.sort(nums);
        // int i=0;
        // while(i<nums.length-1){
        //     pq.add(new Element(Math.abs(nums[i+1]-nums[i]), i, i+1));
        //     i++;
        // }
        // int ans=0;
        // while(k>0){
        //     Element element = pq.remove();
        //     ans = element.diff;
        //     k--;
        //     if(element.indexEnd==nums.length-1){
        //         continue;
        //     }
        //     int newDiff = Math.abs(nums[element.indexStart]-nums[element.indexEnd+1]);
        //     pq.add(new Element(newDiff, element.indexStart, element.indexEnd+1));
        // }
        // return ans;
        Arrays.sort(nums);
        int l=0, r=nums[nums.length-1]-nums[0];
        while(l<r){
            int mid = l+(r-l)/2;
            int count = findCount(nums, mid);
            if(count<k){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
    public int findCount(int[] nums, int maxDist){
        int i=0, count=0;
        int dist=0;
        for(int j=1; j<nums.length; j++){
            while(nums[j]-nums[i]>maxDist){
                i++;
            }
            count += (j-i);
        }
        return count;
    }
}