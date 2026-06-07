class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length>h){
            return -1;
        }
        int minSpeed=1, maxSpeed=1;
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }
        while(minSpeed < maxSpeed){
            int midSpeed = minSpeed + (maxSpeed-minSpeed)/2;
            if(!canEat(piles, midSpeed, h)){
                minSpeed = midSpeed+1;
            }
            else{
                maxSpeed = midSpeed;
            }
        }
        return minSpeed;
    }
    public boolean canEat(int[] piles, int midSpeed, int h){
        int timeTaken=0;
        for(int pile:piles){
            timeTaken += pile/midSpeed;
            if(pile%midSpeed != 0){
                timeTaken++;
            }
        }
        return timeTaken<=h;
    }
}