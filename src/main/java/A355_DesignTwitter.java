import java.util.*;

public class A355_DesignTwitter {
    private static int timeStamp = 0;

    private Map<Integer, User> userMap;
    Map<Integer, List<Tweet>> tweets = new HashMap<>();

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

     public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        /**
         * 添加关注
         * @param id 用户Id
         */
        public void follow(int id){
            followed.add(id);
        }

        /**
         * 取消关注
         * @param id 用户Id
         */
        public void unfollow(int id){
            followed.remove(id);
        }

        /**
         * 更新推文
        * @param id 推文Id
         */
        public void post(int id){
            Tweet tweet = new Tweet(id);
            tweet.next = tweet_head;
            tweet_head = tweet;
        }
    }

    public A355_DesignTwitter(){
        userMap = new HashMap<Integer, User>();
    }

    /**
     * 更新推文
     * @param userId  用户Id
     * @param tweetId 推文Id
     */
    public void postTweet(int userId, int tweetId){
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * 获取最新推文
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId){
        List<Integer> res = new LinkedList<>();
        if(!userMap.containsKey(userId))
            return res;

        Set<Integer> users = userMap.get(userId).followed;      // 所有关注者的Id集合
        if(users.size() == 0)
            return res;
        PriorityQueue<Tweet> q = new PriorityQueue<>(users.size(), (a, b)->(b.time - a.time));  // 构建优先队列
        for(int user : users){
            Tweet t = userMap.get(user).tweet_head; // 获取每个用户的第一条推文
            if(t != null)   //非常重要，要保证推文不为空，才入优先队列
                q.add(t);
        }
        int n = 0;
        while(!q.isEmpty() && n < 10){
            Tweet t = q.poll() ;    // 在队列中获取第一条推文
            res.add(t.id);          // 将推文Id保存在结果List中
            n++;
            if(t.next != null)      // 将该推文的下一个推文加入优先队列中
                q.add(t.next);
        }

        return res;
    }

    /**
     * 添加关注
     * @param followerId 被关注者Id
     * @param followeeId 关注者Id（跟随者Id）
     */
    public void follow(int followerId, int followeeId){
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * 取消关注
     * @param followerId 被关注者Id
     *  @param followeeId 关注者Id（跟随者Id）
     */
    public void unfollow(int followerId, int followeeId){
        if(!userMap.containsKey(followerId) || followeeId == followerId)
            return ;
        userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] args) {
        A355_DesignTwitter twitter = new A355_DesignTwitter();
        twitter.postTweet(1, 5);
        twitter.unfollow(1,1);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
//        twitter.unfollow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));
    }

}
