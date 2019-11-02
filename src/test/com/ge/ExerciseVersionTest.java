package com.ge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExerciseVersionTest {

    @Test
    public void getVersionTest() {
        assertEquals("1.0", ExerciseVersion.getVersion());
    }
}