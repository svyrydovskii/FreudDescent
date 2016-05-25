import freud.FreudApp;
import freud.FreudRetweeter;
import org.junit.Ignore;
import org.junit.Test;
import twitter4j.*;

import java.util.List;


import static org.junit.Assert.*;

/**
 * The tests that employ the Twitter API are disabled because I don't wand to hit rate limit too often.
 */
public class AppTest {

    @Test
    @Ignore
    public void testSearch(){
        FreudRetweeter fr = new FreudRetweeter();
        List<Status> statuses = fr.searchTweets();
        for (Status s: fr.searchTweets()){
            System.out.println(s.getText());
            assertNotNull(statuses);
            assertTrue(statuses.size()>0);
        }
    }

    @Test
    @Ignore
    public void testNotDuplicates() throws TwitterException{
        FreudRetweeter fr = new FreudRetweeter();
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.getUserTimeline().get(0);
        assertFalse(fr.notDuplicate(twitter.getUserTimeline().get(0)));
    }

}
