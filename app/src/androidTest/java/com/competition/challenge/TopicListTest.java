package com.competition.challenge;

import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityTestCase;

import com.competition.challenge.model.Topic;
import com.competition.challenge.utils.TopicsManager;
import com.competition.challenge.utils.Utility;

import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 * Created by Sagar on 4/12/2018.This class is responsible for unit testing on the topic list
 */


public class TopicListTest extends ActivityTestCase {

    /**
     * test whether list is empty or not
     */
    public void testListEmpty(){
        Utility.createTopics();

        //check if list is null or not
        Assert.assertNotNull("List shouldn't be null", TopicsManager.getInstance().getList());

        //check size of list.Actual size is 4
        Assert.assertEquals("Wrong size", 4, TopicsManager.getInstance().getList().size());

    }

    /**
     * test adding a new element to list
     */
    public void testaddList(){
        Topic topic=new Topic();
        topic.setTitle("test");
        topic.setDescription("testdesc");

        Utility.addTopic(topic);

        //Check list size.actual size is 5
        Assert.assertEquals("Wrong size", 5, TopicsManager.getInstance().getList().size());

        //match last element title
        Assert.assertEquals("Wrong last element", "test",  TopicsManager.getInstance().getList().get(4).getTitle());
    }

    /**
     * Test case to update an item in list
     */
    public void testupdateList(){
        Topic topic=TopicsManager.getInstance().getList().get(4);

        topic.setTitle("new title");

        Utility.updateList(4,topic);

        //check size of list
        Assert.assertEquals("Wrong size", 5, TopicsManager.getInstance().getList().size());

        //check if last item is updated or not
        Assert.assertNotEquals("Wrong last element", "test",  TopicsManager.getInstance().getList().get(4).getTitle());
        Assert.assertEquals("Wrong last element", "new title",  TopicsManager.getInstance().getList().get(4).getTitle());

    }
}
