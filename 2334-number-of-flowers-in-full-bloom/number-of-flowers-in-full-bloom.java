class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        // {1:1}, {3:1}, {4,1}, {6,-1}, {7,-1}, {} .....

        TreeMap<Integer, Integer> flowerCount = new TreeMap<>();
        for(int[] flower:flowers){
            flowerCount.put(flower[0], flowerCount.getOrDefault(flower[0], 0)+1);
            flowerCount.put(flower[1]+1, flowerCount.getOrDefault(flower[1]+1, 0)-1);
        }
        for(int flower:flowerCount.keySet()){
            Integer startLower = flowerCount.lowerKey(flower);
            if(startLower == null){
                flowerCount.put(flower, flowerCount.get(flower));
                continue;
            }
            flowerCount.put(flower, flowerCount.get(startLower)+flowerCount.get(flower));
        }
        for(int i=0; i<people.length; i++){
            if(flowerCount.lowerKey(people[i])==null){
                if(flowerCount.containsKey(people[i])){
                    people[i] = flowerCount.get(people[i]);
                }
                else{
                    people[i]=0;
                }
                continue;
            }
            if(flowerCount.containsKey(people[i])){
                people[i] = flowerCount.get(people[i]);
            }
            else{
                people[i] = flowerCount.get(flowerCount.lowerKey(people[i]));
            }
        }
        return people;
    }
}