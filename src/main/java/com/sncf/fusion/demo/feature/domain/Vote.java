package com.sncf.fusion.demo.feature.domain;

import java.util.Optional;

public class Vote {

    private int note;
    private String author;

    public Vote(int note) {
        this.note = note;
        this.author = "anonymous";
    }
    public Vote(int note, String author) {
        this.note = note;
        this.author = author;
    }

    public Vote getSecureVote() {
        return Optional.of(this)
                    .filter(vote -> vote.note >= 1)
                    .map(this::scoreAboveThreshold)
                    .orElseGet(this::scoreBelowThreshold);
    }

    private Vote scoreAboveThreshold(Vote vote) {
        vote.note = 1;
        return vote;
    }

    private Vote scoreBelowThreshold() {
        this.note = -1;
        return this;
    }
    public int getNote() {
        return note;
    }

    public String getAuthor() {
        return author;
    }
}
