package com.sncf.fusion.demo.feature.infra.adapters.primary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sncf.fusion.demo.feature.domain.Feature;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class FeatureAPI {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private List<VoteAPI> votes;
    @JsonProperty
    private List<String> themes;
    @JsonProperty
    private List<String> customers;
    @JsonProperty
    private int score;

    public FeatureAPI(String id, String name, String description, List<VoteAPI> votes, List<String> themes, List<String> customers, int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.votes = votes;
        this.themes = themes;
        this.customers = customers;
        this.score = score;
    }

    public FeatureAPI(Feature feature) {
        this.id = feature.getId();
        this.name = feature.getName();
        this.description = feature.getDescription();
        this.votes = feature.getVotes().stream().map(VoteAPI::new).collect(Collectors.toList());
        this.customers = feature.getCustomers();
        this.themes = feature.getThemes();
        this.score = feature.getScore();
    }

    public Feature toFeature() {
        return new Feature(Objects.nonNull(this.id) ? id : "", this.name, this.description,
                this.votes.stream().map(VoteAPI::toVote).collect(Collectors.toList()), this.themes, this.customers);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VoteAPI> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteAPI> votes) {
        this.votes = votes;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        this.themes = themes;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
