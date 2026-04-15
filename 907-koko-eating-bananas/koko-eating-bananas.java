class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxPile = 0;
        for(int pile:piles){
            maxPile = Math.max(maxPile, pile);
        }
        int maxSpeed = maxPile;
        Arrays.sort(piles);
        while(minSpeed < maxSpeed){
            int midSpeed = minSpeed + (maxSpeed-minSpeed)/2;
            if(!canEat(piles, h, midSpeed)){
                minSpeed = midSpeed+1;
            }
            else{
                maxSpeed = midSpeed;
            }
        }
        return minSpeed;
    }
    public boolean canEat(int[] piles, int h, int speed){
        int currHours = 0;
        for(int i=piles.length-1; i>=0; i--){
            if(piles[i]>=speed){
                currHours += piles[i]/speed;
                if(piles[i]%speed != 0){
                    currHours++;
                }
            }
            else{
                currHours++;
            }
            if(currHours > h){
                return false;
            }
        }
        return true;
    }
}