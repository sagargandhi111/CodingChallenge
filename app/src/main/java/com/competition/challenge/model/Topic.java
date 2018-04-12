package com.competition.challenge.model;

import java.io.Serializable;

/**
 * Created by Sagar on 4/12/2018.
 */

public class Topic implements Serializable{

    private String mTitle;

    private String mDescription;

    private int mUpVote;

    private int mDownVote;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getUpVote() {
        return mUpVote;
    }

    public void setUpVote(int mUpVote) {
        this.mUpVote = mUpVote;
    }

    public int getDownVote() {
        return mDownVote;
    }

    public void setDownVote(int mDownVote) {
        this.mDownVote = mDownVote;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
