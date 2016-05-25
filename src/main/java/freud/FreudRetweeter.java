package freud;

import twitter4j.*;

import java.util.List;

/**
 * Created by Andrii Svyrydovskyi on 25/05/2016.
 */
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

//            do {
//                result = twitter.search(query);
//                List<Status> tweets = result.getTweets();
//                for (Status tweet : tweets) {
//                    twitter.retweetStatus(tweet.getId());
//                    //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
//                }
//            } while ((query = result.nextQuery()) != null);
//            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            return null;
        }

}
}

