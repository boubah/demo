package com.sncf.fusion.demo.feature.domain.ports.primary;

import com.sncf.fusion.demo.feature.domain.Feature;
import com.sncf.fusion.demo.feature.domain.Vote;
import com.sncf.fusion.demo.feature.domain.ports.secondary.FeatureRecords;
import com.sncf.fusion.demo.patternity.annotation.ddd.stereotype.DomainService;

import java.util.List;

@DomainService
public class FeatureManagement {

    private FeatureRecords featureRecords;

    public FeatureManagement(FeatureRecords featureRecords) {
        this.featureRecords = featureRecords;
    }

    public List<Feature> getAllFeatures() {
        return featureRecords.getAllFeatures();
    }

    public Feature getOneFeature(String featureId) {
        return featureRecords.getOneFeature(featureId);
    }

    public Feature addFeature(Feature feature) {
        featureRecords.addFeature(feature);
        return feature;
    }

    public Boolean vote(String featureId, Vote vote) {
        return featureRecords.vote(featureId, vote.getSecureVote());
    }
}
