package com.competition.challenge.utils;

import com.competition.challenge.model.Topic;

/**
 * Created by Sagar on 4/12/2018.It is a controller class mainly responsible for handling operations on list
 */

public class Utility {

    /**
     * Create a random list of dummy data to show.
     */
    public static void createTopics(){
        Topic firstTopic= new Topic();
        firstTopic.setTitle("The New Gmail Design");
        firstTopic.setUpVote(4);
        firstTopic.setDownVote(1);
        firstTopic.setDescription("The refreshed design will appear for Gmail users on the web, bringing it closer to the company's tweaks for Gmail on mobile devices. ");

        //get the list and add item into it.
        TopicsManager.getInstance().addToList(firstTopic);


        Topic secondTopic = new Topic();
        secondTopic.setTitle("The Global Housing Crisis ");
        secondTopic.setUpVote(3);
        secondTopic.setDownVote(2);
        secondTopic.setDescription("Scarce, unaffordable housing is not a local problem in a few places, but is baked into the 21st-century global city. And it's worst in the developing world. ");

        TopicsManager.getInstance().addToList(secondTopic);

        Topic thirdTopic = new Topic();
        thirdTopic.setTitle("The Secret Language Of Ships ");
        thirdTopic.setUpVote(8);
        thirdTopic.setDownVote(3);
        thirdTopic.setDescription("Signs and symbols on the sides of ships tell stories about an industry few outsiders understand.\n");

        TopicsManager.getInstance().addToList(thirdTopic);

        Topic fourthTopic = new Topic();
        fourthTopic.setTitle("Letter Of Recommendation: AliExpress ");
        fourthTopic.setUpVote(1);
        fourthTopic.setDownVote(0);
        fourthTopic.setDescription("It's not quite shopping — it's more like mainlining late capitalism. ");

        TopicsManager.getInstance().addToList(fourthTopic);

    }

    public static void addTopic(Topic topic){
        //get singleton instance and add item to list
        TopicsManager.getInstance().addToList(topic);
    }

    public static void updateList(int pos,Topic topic){
        //update the item of list with new count
        TopicsManager.getInstance().getList().set(pos,topic);
    }
}
