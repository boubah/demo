package com.sncf.fusion.demo.feature.infra.adapters.secondary.dto;

import com.sncf.fusion.demo.feature.domain.Vote;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator
public class VoteMongoRecord {

    private int note;

    private String author;

    @BsonCreator
    public VoteMongoRecord(@BsonProperty("note") int note, @BsonProperty("author") String author) {
        this.note = note;
        this.author = author;
    }


    public VoteMongoRecord(Vote vote) {
        this.note = vote.getNote();
        this.author = vote.getAuthor();
    }

    public Vote toVote() {
        return new Vote(note, author);
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
