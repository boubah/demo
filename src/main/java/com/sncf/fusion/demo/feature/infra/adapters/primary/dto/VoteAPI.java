package com.sncf.fusion.demo.feature.infra.adapters.primary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sncf.fusion.demo.feature.domain.Vote;

public class VoteAPI {
    @JsonProperty
    private int note;
    @JsonProperty
    private String author;

    public VoteAPI(int note, String author) {
        this.note = note;
        this.author = author;
    }

    public VoteAPI(Vote vote) {
        this.note = vote.getNote();
        this.author = vote.getAuthor();
    }

    public Vote toVote() {
        return new Vote(this.note, this.author);
    }
}
