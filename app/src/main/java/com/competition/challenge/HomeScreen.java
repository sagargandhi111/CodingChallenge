package com.competition.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.competition.challenge.adapter.TopicListAdapter;
import com.competition.challenge.model.Topic;
import com.competition.challenge.utils.RecyclerItemClickListener;
import com.competition.challenge.utils.TopicsManager;
import com.competition.challenge.utils.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by Sagar Gandhi on 4/12/2018.This class is responsible to show the list of all topics.
 */

public class HomeScreen extends Activity{

    private RecyclerView mTopicListView;
    private ImageView mAddTopicView;
    private ArrayList<Topic> mList;
    private Boolean isSplash=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Bundle extras = getIntent().getExtras();

        if(extras!=null && extras.getBoolean("splash")) {
            isSplash = extras.getBoolean("splash");
        }

        //if application is coming from splash only then creates the list with dummy data
        if(isSplash) {
            Utility.createTopics();
        }
        mTopicListView= (RecyclerView)findViewById(R.id.topics_list);
        mAddTopicView= (ImageView)findViewById(R.id.addtopic);

        mAddTopicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, AddTopic.class);
                startActivity(i);
            }
        });

        mList=TopicsManager.getInstance().getList();

        //sort list in ascending order on basis of upvotes
        Collections.sort(
                mList,
                new Comparator<Topic>()
                {
                    public int compare(Topic lhs, Topic rhs)
                    {
                        return Integer.compare(lhs.getUpVote(), rhs.getUpVote());
                    }
                }
        );
        TopicListAdapter adapter = new TopicListAdapter(mList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mTopicListView.setLayoutManager(mLayoutManager);


        mTopicListView.setAdapter(adapter);

        //handle list click.open details page
        mTopicListView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), mTopicListView ,
                        new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent i = new Intent(HomeScreen.this,TopicDetailView.class);
                        i.putExtra("position",position);
                        i.putExtra("Topic",mList.get(position));

                        startActivity(i);
                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                }));


    }


}
