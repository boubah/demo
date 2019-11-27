package com.sncf.fusion.demo.feature.domain.ports.secondary;

import com.sncf.fusion.demo.feature.domain.Feature;
import com.sncf.fusion.demo.feature.domain.Vote;

import java.util.List;

public interface FeatureRecords {
    List<Feature> getAllFeatures();
    Feature getOneFeature(String featureId);
    String addFeature(Feature feature);
    Boolean vote(String featureId, Vote vote);
}
