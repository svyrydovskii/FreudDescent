package freud;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.*;
import java.util.List;

@Component
public class FreudApp {

    @Scheduled(cron = "20 16 * * 2,5") //will run at 4:20 PM each Tuesday and Friday
    public void performFreudSearch(){
        FreudRetweeter rt = new FreudRetweeter();
        List<Status> statuses = rt.searchTweets();
        for (Status s : statuses){
            if (rt.notDuplicate(s)){
                rt.retweet(s);
            }
        }
    }
}


