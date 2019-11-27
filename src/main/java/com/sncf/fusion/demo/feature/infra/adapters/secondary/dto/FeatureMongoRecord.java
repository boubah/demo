package com.sncf.fusion.demo.feature.infra.adapters.secondary.dto;

import com.sncf.fusion.demo.feature.domain.Feature;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@BsonDiscriminator
public class FeatureMongoRecord {


    private String id;

    private String name;

    private String description;

    private List<VoteMongoRecord> votes;

    private List<String> themes;

    private List<String> customers;

    private int score;

    @BsonCreator
    public FeatureMongoRecord(@BsonProperty("id") String id, @BsonProperty("name") String name, @BsonProperty("description") String description,
                              @BsonProperty("votes") List<VoteMongoRecord> votes, @BsonProperty("themes") List<String> themes,
                              @BsonProperty("customers") List<String> customers, @BsonProperty("score") int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.votes = votes;
        this.themes = themes;
        this.customers = customers;
        this.score = score;
    }

    public FeatureMongoRecord(Feature feature) {
        if (!Objects.equals("",feature.getId())) {
            this.id = feature.getId();
            this.name = feature.getName();
            this.votes = feature.getVotes().stream().map(VoteMongoRecord::new).collect(Collectors.toList());
            this.themes = feature.getThemes();
            this.customers = feature.getCustomers();
            this.description = feature.getDescription();
            this.score = feature.getScore();
        }
    }

    public Feature toFeature() {
        return new Feature(Objects.nonNull(id) ? id :"", name, description,
                votes.stream().map(VoteMongoRecord::toVote).collect(Collectors.toList()), themes, customers);
    }

    @BsonId
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<VoteMongoRecord> getVotes() {
        return votes;
    }

    public List<String> getThemes() {
        return themes;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public int getScore() {
        return score;
    }
}
