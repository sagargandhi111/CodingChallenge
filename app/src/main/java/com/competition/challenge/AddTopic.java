package com.competition.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.competition.challenge.model.Topic;
import com.competition.challenge.utils.TopicsManager;
import com.competition.challenge.utils.Utility;

/**
 * Created by Sagar on 4/12/2018.This class is responsible for adding a new topic.
 */

public class AddTopic extends Activity{

    private EditText mTitle,mDescription;
    private TextView mSubmitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtopic);

        mTitle=(EditText)findViewById(R.id.titleeditbox);
        mDescription=(EditText)findViewById(R.id.desceditbox);

        mSubmitBtn=(TextView)findViewById(R.id.submitbtn);

        //fetch topic details and add it to the list
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTitle.getText().toString().isEmpty() ||
                        mDescription.getText().toString().isEmpty()) {
                    //empty fields.show error
                    Toast.makeText(AddTopic.this, "Please fill all the fields.",
                            Toast.LENGTH_LONG).show();
                }else {
                    Topic topic = new Topic();
                    topic.setTitle(mTitle.getText().toString());
                    topic.setDescription(mDescription.getText().toString());

                    //add item to list
                    Utility.addTopic(topic);

                    Intent i =new Intent(AddTopic.this,HomeScreen.class);
                    startActivity(i);
                    finish();

                }

            }
        });
    }
}
