class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean firstMatch=false, secondMatch=false, thirdMatch=false;
        for(int i=0; i<triplets.length; i++){
            if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2]){
                continue;
            }
            if(triplets[i][0]==target[0]) firstMatch=true;
            if(triplets[i][1]==target[1]) secondMatch=true;
            if(triplets[i][2]==target[2]) thirdMatch=true;

            if(firstMatch && secondMatch && thirdMatch){
                return true;
            }
        }
        return false;
    }
}