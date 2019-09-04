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
        assertNotEquals(new Probability(0.56f), new Probability(0.57f));
    }

    @Test
    void givenPointFiveOccurrenceProbability_WhenChecksNonOccurredProbability_ThenReturnsPointFive() {
        assertEquals(certainEvent, impossibleEvent.notOccurring());
    }

    @Test
    void givenOneOcuProbability_WhenChecksUnoccuredProbability_ThenReturnsZero() {
        assertEquals(impossibleEvent, certainEvent.notOccurring());
    }

    @Test
    void givenTwoZeroProbabilites_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsZero() {
        assertEquals(impossibleEvent, impossibleEvent.occurringTogether(impossibleEvent));
    }

    @Test
    void givenPointThreeProbability_WhenCalculatingProbabilityOfEventsOccurringTogether_ThenReturnsPointNine() {
        Probability pointThreeProbability= new Probability(0.5f);
        assertEquals(new Probability(0.25f), pointThreeProbability.occurringTogether(pointThreeProbability));
    }

    @Test
    void givenTwoZeroNonOccurringProbability_WhenCalculatedTogether_ThenReturnProbabilities() {
        assertEquals(impossibleEvent,impossibleEvent.or(impossibleEvent));
    }
}
