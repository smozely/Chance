package com.stevemosley.chance;

import static com.stevemosley.test.hamcrest.RegexMatcher.matches;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.google.common.primitives.Chars;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

/**
 * All tests here using a fixed seed number so tests are repeatable.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ChanceTest {

    private final Chance underTest = new Chance(1234567890);

    @Test
    public void testWithDefaultConstructor() throws Exception {
        Chance constructed = new Chance();

        // Just ensure that the Chance instance can be used
        constructed.aBool();
    }

    @Test
    public void testWithSeedConstructor() throws Exception {
        Chance constructed = new Chance(1);

        // Since this has been created with a fixed seed result will always be the same
        assertEquals(true, constructed.aBool());
    }

}
