package com.competition.challenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.competition.challenge.R;
import com.competition.challenge.model.Topic;
import com.competition.challenge.viewholder.TopicViewHolder;

import java.util.List;

/**
 * Created by Sagar  on 4/12/2018.Adapter class for displaying list items
 */

public class TopicListAdapter extends RecyclerView.Adapter<TopicViewHolder>{

    private List<Topic> topicList;

    public TopicListAdapter(List<Topic> list) {
        this.topicList = list;
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_list_row, parent, false);

        return new TopicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopicViewHolder holder, int position) {

        Topic topic = topicList.get(position);
        holder.mTitle.setText(topic.getTitle());
        holder.mUpVoteCount.setText(""+topic.getUpVote());
        holder.mDownVoteCount.setText(""+topic.getDownVote());
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }
}
