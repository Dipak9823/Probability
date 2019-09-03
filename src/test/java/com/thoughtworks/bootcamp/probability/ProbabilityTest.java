package com.thoughtworks.bootcamp.probability;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {

    @Test
    void givenProbabilityOfTwoEventsPointFive_WhenCompared_ThenReturnTrue(){
        Probability probability1=new Probability(0.5f);
        Probability probability2=new Probability(0.5f);
        assertTrue(probability1.equals(probability2));
    }

    @Test
    void givenProbabilityOfEventPointFive_WhenNotOccuring_ThenReturnPointFive() {
        Probability probability=new Probability(0.5f);
        assertEquals(0.5,probability.notOccuring());
    }

}
