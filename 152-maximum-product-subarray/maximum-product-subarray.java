// class Solution {
//     public int maxProduct(int[] nums) {
//         int negProd = 1;
//         int currProd = 1;
//         int maxProd = Integer.MIN_VALUE;
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         for(int num:nums){
//             currProd *= num;
//             if(currProd<0){
//                 if(!minHeap.isEmpty()){
//                     maxProd = Math.max(maxProd, currProd/minHeap.peek());
//                 }
//                 minHeap.add(currProd);
//             }
//         }
//         return maxProd;
//     }
// }
class Solution {
    public int maxProduct(int[] nums) {
        int negProd = 1;
        int currProd = 1;
        int maxProd = Integer.MIN_VALUE;
        for(int num:nums){
            currProd *= num;
            maxProd = Math.max(maxProd, currProd);
            if(currProd<0){
                if(negProd==1){
                    negProd = currProd;
                }
                else{
                    maxProd = Math.max(maxProd, currProd/negProd);
                }
            }
            else if(currProd==0){
                negProd=1;
                currProd=1;
            }
        }
        return maxProd;
    }
}