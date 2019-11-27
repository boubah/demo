package com.sncf.fusion.demo.domain;

import com.sncf.fusion.demo.feature.domain.Feature;
import com.sncf.fusion.demo.feature.domain.Vote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FeatureModelTests {

    @Test
    public void should_score_correctly_a_list_of_votes() {
        List<Vote> votes = Arrays.asList(new Vote(1), new Vote(-1), new Vote(1), new Vote(1));
        Feature feature = new Feature(votes);
        int score = feature.getScore();

        Assertions.assertEquals(2, score);
    }

    @Test
    public void should_not_cheat_like_french_politics() {
        Vote vote = new Vote(10);
        Vote secVote = vote.getSecureVote();

        Assertions.assertEquals(1, secVote.getNote());
    }

    @Test
    public  void should_not_cheat_by_minus() {
        Vote vote = new Vote(-2);
        Vote secVote = vote.getSecureVote();
        Assertions.assertEquals(-1, secVote.getNote());
    }
}
