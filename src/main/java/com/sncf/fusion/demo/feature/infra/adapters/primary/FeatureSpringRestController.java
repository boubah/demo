package com.sncf.fusion.demo.feature.infra.adapters.primary;

import com.sncf.fusion.demo.feature.domain.ports.primary.FeatureManagement;
import com.sncf.fusion.demo.feature.infra.adapters.primary.dto.FeatureAPI;
import com.sncf.fusion.demo.feature.infra.adapters.primary.dto.VoteAPI;
import com.sncf.fusion.demo.patternity.annotation.designpattern.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Adapter
public class FeatureSpringRestController {
    @Autowired
    private FeatureManagement featureManagement;

    @GetMapping("/feature")
    @ResponseBody
    public List<FeatureAPI> features() {
        return featureManagement.getAllFeatures().stream().map(FeatureAPI::new).collect(Collectors.toList());
    }

    @GetMapping("/feature/{featureid}")
    @ResponseBody
    public FeatureAPI get(@PathVariable String featureid) {
        return new FeatureAPI(featureManagement.getOneFeature(featureid));
    }

    @PostMapping("/feature")
    @ResponseBody
    public FeatureAPI newFeature(@RequestBody FeatureAPI feature) {
        return new FeatureAPI(featureManagement.addFeature(feature.toFeature()));
    }

    @PostMapping("/feature/{featureid}/vote")
    @ResponseBody
    public Boolean vote(@RequestBody VoteAPI vote, @PathVariable String featureid) {
        return featureManagement.vote(featureid, vote.toVote());
    }
}
