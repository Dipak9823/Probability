package com.thoughtworks.bootcamp.probability;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {
    private static Probability impossibleEvent;
    private static Probability certainEvent;

    @BeforeAll
    static void setUp() {
        impossibleEvent = new Probability(0.0f);
        certainEvent = new Probability(1.0f);
    }
    @Test
    void givenProbabilitiesOfOneEventZeroAndSecondEventOne_WhenChecksEquality_ThenReturnsFalse() {
        assertEquals(false, impossibleEvent.equals(certainEvent));
    }
    @Test
    void givenTwoProbabilities_whenChecksEquality_ThenReturnsFalse() {
        assertNotEquals(new Probability(0.5f), new Probability(0.6f));
    }

    @Test
    void givenPointFiveOccurrenceProbability_WhenChecksNonOccurredProbability_ThenReturnsPointFive() {
        assertEquals(certainEvent, impossibleEvent.notOccurrence());
    }

    @Test
    void givenOneOcuProbability_WhenChecksUnoccuredProbability_ThenReturnsZero() {
        assertEquals(impossibleEvent, certainEvent.notOccurrence());
    }

    @Test
    void givenTwoZeroProbabilites_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsZero() {
        assertEquals(impossibleEvent, impossibleEvent.and(impossibleEvent));
    }

    @Test
    void givenPointThreeProbability_WhenCalculatingProbabilityOfEventsOccurringTogether_ThenReturnsPointNine() {
        Probability pointThreeProbability= new Probability(0.5f);
        assertEquals(new Probability(0.25f), pointThreeProbability.and(pointThreeProbability));
    }

    @Test
    void givenTwoZeroNonOccurringProbability_WhenCalculatedTogether_ThenReturnZero() {
        assertEquals(impossibleEvent,impossibleEvent.or(impossibleEvent));
    }

    @Test
    void givenTwoOneNonOccurringProbability_WhenCalculatedTogether_ThenReturnProbabilities() {
        assertEquals(certainEvent,certainEvent.or(certainEvent));
    }

    @Test
    void givenTwoZeoPointFiveProbability_WhenCalculateTogether_ThenReturnProbabilities() {
        Probability headInToss=new Probability(0.5f);
        Probability tailInToss=new Probability(0.5f);
        assertEquals(new Probability(0.75f),headInToss.or(tailInToss));
    }
}
