package com.competition.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.competition.challenge.model.Topic;
import com.competition.challenge.utils.TopicsManager;
import com.competition.challenge.utils.Utility;

/**
 * Created by Sagar on 4/12/2018.This class is responsible to show the detail of topic
 */

public class TopicDetailView extends Activity{

    private TextView mTitleView,mDescriptionView,mVoteUp,mVoteDown;

    private int mPosition;
    private Topic mTopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_topic_detail);

        //get data from previous screen
        Bundle extras = getIntent().getExtras();

        if(getIntent().getSerializableExtra("Topic")!=null){
           mTopic=(Topic) getIntent().getSerializableExtra("Topic");
        }


        mPosition = extras.getInt("position");


        mTitleView=(TextView) findViewById(R.id.topictitle);
        mDescriptionView=(TextView)findViewById(R.id.topicdescription);

        mVoteUp=(TextView) findViewById(R.id.voteup);
        mVoteDown=(TextView) findViewById(R.id.votedown);

        //vote up the topic and update in list
        mVoteUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int upvote=mTopic.getUpVote();
                upvote=upvote+1;

                mTopic.setUpVote(upvote);

                //update the item of list with new count
                Utility.updateList(mPosition,mTopic);

                Intent i =new Intent(TopicDetailView.this,HomeScreen.class);
                startActivity(i);

                //remove all previous screens from stack
                finish();
            }
        });

        //vote down the topic and update in list
        mVoteDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int downvote=mTopic.getDownVote();
                downvote=downvote+1;

                mTopic.setDownVote(downvote);

                //update the list with new count
                Utility.updateList(mPosition,mTopic);

                Intent i =new Intent(TopicDetailView.this,HomeScreen.class);
                startActivity(i);
                finish();

            }
        });

        mTitleView.setText(mTopic.getTitle());
        mDescriptionView.setText(mTopic.getDescription());
    }
}
