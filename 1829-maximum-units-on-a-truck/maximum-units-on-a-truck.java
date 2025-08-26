class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        System.out.println(boxTypes[1][1]);
        int units=0;
        for(int i=0; i<boxTypes.length; i++){
            while(truckSize>0 && boxTypes[i][0]>0){
                boxTypes[i][0]--;
                units += boxTypes[i][1];
                truckSize--;
            }
        }
        return units;
    }
}