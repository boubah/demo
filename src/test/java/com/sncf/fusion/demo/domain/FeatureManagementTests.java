package com.sncf.fusion.demo.domain;

import com.sncf.fusion.demo.domain.mocks.MockFeatureRecords;
import com.sncf.fusion.demo.feature.domain.Feature;
import com.sncf.fusion.demo.feature.domain.ports.primary.FeatureManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FeatureManagementTests {
    private FeatureManagement featureManagement;

    @Test
    public void should_get_all_features() {
        featureManagement = new FeatureManagement(new MockFeatureRecords());
        List<Feature> result = featureManagement.getAllFeatures();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("A", result.get(0).getName());
        Assertions.assertEquals("B", result.get(1).getName());
    }
}
