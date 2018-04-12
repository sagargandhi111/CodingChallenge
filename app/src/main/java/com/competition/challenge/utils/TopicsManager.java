package com.competition.challenge.utils;

import com.competition.challenge.model.Topic;

import java.util.ArrayList;

/**
 * Created by Sagar on 4/12/2018.This class is responsible for maintaining the topic list state.It uses singleton design pattern.
 * List state is maintained until whole application is restarted.
 */

public class TopicsManager {

    private static TopicsManager mInstance;
    private ArrayList<Topic> mTopicList = null;

    public static TopicsManager getInstance() {
        if(mInstance == null)
            mInstance = new TopicsManager();

        return mInstance;
    }

    private TopicsManager() {
        mTopicList = new ArrayList<Topic>();
    }

    // retrieve topic list from anywhere
    public ArrayList<Topic> getList() {
        return this.mTopicList;
    }
    //Add element to topic list
    public void addToList(Topic value) {

        mTopicList.add(value);
    }
}
