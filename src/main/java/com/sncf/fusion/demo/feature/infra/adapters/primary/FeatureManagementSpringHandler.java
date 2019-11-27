package com.sncf.fusion.demo.feature.infra.adapters.primary;

import com.sncf.fusion.demo.feature.domain.ports.primary.FeatureManagement;
import com.sncf.fusion.demo.feature.domain.ports.secondary.FeatureRecords;
import com.sncf.fusion.demo.patternity.annotation.designpattern.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Adapter
public class FeatureManagementSpringHandler extends FeatureManagement {
    @Autowired
    public FeatureManagementSpringHandler(FeatureRecords featureRecords) {
        super(featureRecords);
    }
}
