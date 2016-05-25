package freud;

import twitter4j.*;

import java.util.List;

public class FreudRetweeter {

    private Twitter twitter;

    public FreudRetweeter(){
        twitter= new TwitterFactory().getInstance();
    }

    public boolean notDuplicate(Status status){
        List<Status> timeline;
        try {
            timeline = twitter.getUserTimeline();
            for (Status s : timeline){
                if (status.getId()==s.getId()){
                    return false;
                }
            }
            return true;
        }
        catch (TwitterException te){
            System.out.println("Error getting Freud timeline: " + te.getMessage());
            return false;
        }
    }

    public void retweet(Status status){
        try {
            twitter.retweetStatus(status.getId());
        }
        catch(TwitterException te){
            System.out.println("Error retweeting: " + te.getMessage());
        }
    }

    public List<Status> searchTweets(){
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query("дедушка Фрейд");
            QueryResult result;
            result = twitter.search(query);
            return result.getTweets();

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            return null;
        }

}
}

