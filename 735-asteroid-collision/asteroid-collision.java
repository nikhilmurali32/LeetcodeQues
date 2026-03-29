class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> astStack = new ArrayDeque<>();
        for(int ast:asteroids){
            if(!astStack.isEmpty() && ast<0 && astStack.peekLast()>0){
                if(Math.abs(ast)<astStack.peekLast()){
                    continue;
                }
                boolean collided=false;
                while(!astStack.isEmpty() && Math.abs(ast)>=astStack.peekLast() && ast*astStack.peekLast()<0){
                    if(Math.abs(ast)==astStack.peekLast()){
                        astStack.removeLast();
                        collided=true;
                        break;
                    }
                    astStack.removeLast();
                }
                if((astStack.isEmpty() || (astStack.peek()<0 && Math.abs(ast)>astStack.peekLast())) && !collided){
                    astStack.addLast(ast);
                }
            }
            else{
                astStack.addLast(ast);
            }
        }
        int[] res = new int[astStack.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i]=astStack.removeLast();
        }
        return res;

    }
}