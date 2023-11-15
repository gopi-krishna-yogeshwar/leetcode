import java.time.Instant;
class Twitter {
    Map<Integer, Set<Integer>> followers;
    Map<Integer, List<Pair<Integer, Instant>>> userTweets;

    public Twitter() {
        this.followers = new HashMap<Integer, Set<Integer>>();
        this.userTweets = new HashMap<Integer, List<Pair<Integer, Instant>>>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer, Instant>> tweets = this.userTweets.getOrDefault(userId, new ArrayList<>());
        tweets.add(new Pair(tweetId, Instant.now()));
        this.userTweets.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
       
        PriorityQueue<Pair<Integer, Instant>> pq = new PriorityQueue<>((a,b) -> a.getValue().compareTo(b.getValue()));

        Set<Integer> followees = this.followers.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        System.out.println(followees.size());
        for(Integer user : followees) {
            List<Pair<Integer, Instant>> tweets = this.userTweets.getOrDefault(user, new ArrayList());
            for(Pair<Integer, Instant> tweet : tweets) {
                pq.add(tweet);
                if(pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        List<Integer> feed = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            feed.add(pq.poll().getKey());
        }
        Collections.reverse(feed);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> userFollows = this.followers.getOrDefault(followerId, new HashSet<Integer>());
        userFollows.add(followeeId);
        this.followers.put(followerId, userFollows);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(this.followers.containsKey(followerId)) {
            Set<Integer> userFollows = this.followers.getOrDefault(followerId, new HashSet<Integer>());
            if(userFollows.contains(followeeId)) {
                userFollows.remove(followeeId);
                this.followers.put(followerId, userFollows);
            }
        }
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
