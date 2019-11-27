package com.sncf.fusion.demo.feature.domain;

import java.util.ArrayList;
import java.util.List;

public class Feature {
    private String id;
    private String name;
    private String description;
    private List<Vote> votes;
    private List<String> themes;
    private List<String> customers;
    private int score;

    public Feature(String id, String name) {
        this.id = id;
        this.name = name;
        this.description = "description";
        this.votes = new ArrayList<>();
        this.themes = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.score = 0;
    }

    public Feature(List<Vote> votes) {
        this.id = "";
        this.name = "name";
        this.description = "description";
        this.votes = votes;
        this.themes = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.score = this.votes.stream().map(Vote::getNote).reduce(0, Integer::sum);
    }
    public Feature(String id, String name, String description, List<Vote> votes, List<String> themes, List<String> customers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.votes = votes;
        this.themes = themes;
        this.customers = customers;
        this.score = this.votes.stream().map(Vote::getNote).reduce(0, Integer::sum);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Vote> getVotes() {
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
