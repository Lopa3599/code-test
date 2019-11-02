package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE90Test {

    GE90 testEngine;

    @Before
    public void setUp() {
        testEngine = new GE90("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GE90 SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.wetWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
}