package com.sncf.fusion.demo.domain.mocks;

import com.sncf.fusion.demo.feature.domain.Feature;
import com.sncf.fusion.demo.feature.domain.Vote;
import com.sncf.fusion.demo.feature.domain.ports.secondary.FeatureRecords;

import java.util.Arrays;
import java.util.List;

public class MockFeatureRecords implements FeatureRecords {
    @Override
    public List<Feature> getAllFeatures() {
        return Arrays.asList(new Feature("1", "A"), new Feature("2", "B"));
    }

    @Override
    public Feature getOneFeature(String featureId) {
        return null;
    }

    @Override
    public String addFeature(Feature feature) {
        return null;
    }

    @Override
    public Boolean vote(String featureId, Vote vote) {
        return null;
    }
}
