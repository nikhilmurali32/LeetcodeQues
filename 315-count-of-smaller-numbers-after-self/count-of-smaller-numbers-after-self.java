class Solution {
    class ArraywithInd{
        int val;
        int ind;
        ArraywithInd(int val, int ind){
            this.val=val;
            this.ind=ind;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        if(n==0){
            return new ArrayList<>();
        }
        int[] res = new int[n];
        ArraywithInd[] newNums = new ArraywithInd[n];
        for(int i=0; i<n; i++){
            newNums[i] = new ArraywithInd(nums[i], i);
        }
        mergeSort(newNums, 0, n-1, res);
        List<Integer> list = new LinkedList<>();
        for(int j=0; j<n; j++){
            list.add(res[j]);
        }
        return list;
    }

    public void mergeSort(ArraywithInd[] nums, int l, int r, int[] res){
        if(l>=r){
            return;
        }
        int mid=(l+r)/2;
        mergeSort(nums, l, mid, res);
        mergeSort(nums, mid+1, r, res);
        int leftPos=l;
        int rightPos=mid+1;
        LinkedList<ArraywithInd> merged = new LinkedList<ArraywithInd>();
        int numElemRight = 0;
        while(leftPos<mid+1 && rightPos<=r){
            if(nums[leftPos].val>nums[rightPos].val){
                merged.add(nums[rightPos]);
                numElemRight++;
                rightPos++;
            }
            else{
                res[nums[leftPos].ind] += numElemRight;
                merged.add(nums[leftPos]);
                leftPos++;
            }
        }
        while(leftPos<mid+1){
            res[nums[leftPos].ind] += numElemRight;
            merged.add(nums[leftPos]);
            leftPos++;          
        }
        while(leftPos<mid+1){
            merged.add(nums[rightPos]);
            numElemRight++;
            rightPos++;        
        }
        int pos=l;
        for(ArraywithInd m:merged){
            nums[pos]=m;
            pos++;
        }
    }
}