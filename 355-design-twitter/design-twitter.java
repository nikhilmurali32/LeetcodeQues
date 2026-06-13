class Twitter {
    class User{
        int userId;
        List<List<Integer>> tweets = new ArrayList<>();
        HashSet<Integer> followers = new HashSet<>();
        HashSet<Integer> following = new HashSet<>();
        User(int userId){
            this.userId = userId;
        }
    }
    HashMap<Integer, User> users;
    int time=0;
    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        User user = users.get(userId);
        List<List<Integer>> list = user.tweets;
        list.add(Arrays.asList(tweetId, time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<List<Integer>> latestT = new PriorityQueue<>((a,b)->Integer.compare(a.get(1), b.get(1)));
        User user = users.get(userId);
        List<List<Integer>> tweets = user.tweets;
        for(int i=tweets.size()-1; i>=0 && i>=tweets.size()-11; i--){
            latestT.add(tweets.get(i));
            if(latestT.size()>10){
                latestT.remove();
            }
        }
        for(int f:user.following){
            User user1 = users.get(f);
            List<List<Integer>> tweets1 = user1.tweets;
            for(int i=tweets1.size()-1; i>=0 && i>=tweets1.size()-11; i--){
                latestT.add(tweets1.get(i));
                if(latestT.size()>10){
                    latestT.remove();
                }
            }            
        }
        List<Integer> res = new ArrayList<>();
        while(!latestT.isEmpty()){
            res.add(latestT.remove().get(0));
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        } 
        if(!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        } 
        User user = users.get(followerId);
        user.following.add(followeeId);       
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            return;
        } 
        if(!users.containsKey(followeeId)){
            return;
        }
        User user = users.get(followerId);
        user.following.remove(Integer.valueOf(followeeId));         
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */