package com.competition.challenge.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.competition.challenge.R;

/**
 * Created by Sagar on 4/12/2018.ViewHolder for topic list.
 */

public class TopicViewHolder extends RecyclerView.ViewHolder{

    public TextView mTitle, mUpVoteCount, mDownVoteCount;
    public ImageView mUpVote,mDownVote;

    public TopicViewHolder(View view) {
        super(view);
        mTitle = (TextView) view.findViewById(R.id.topicname);
        mUpVoteCount = (TextView) view.findViewById(R.id.upvotecount);
        mDownVoteCount = (TextView) view.findViewById(R.id.downvotecount);

        mUpVote = (ImageView) view.findViewById(R.id.upvoteimage);
        mDownVote = (ImageView) view.findViewById(R.id.downvoteimage);


    }
}
