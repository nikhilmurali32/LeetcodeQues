class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int maxL=0, maxR=0;
        int water=0;
        while(l<=r){
            if(height[l]<=height[r]){
                if(maxL==0){
                    maxL=height[l];
                    l++;
                    continue;
                }
                else{
                    maxL = Math.max(maxL, height[l]);
                    water += (maxL-height[l]);
                    l++;
                }
            }
            else{
                if(maxR==0){
                    maxR=height[r];
                    r--;
                    continue;
                }
                else{
                    maxR = Math.max(maxR, height[r]);
                    water += (maxR-height[r]);
                    r--;
                }                
            }
        }
        return water;
    }
}