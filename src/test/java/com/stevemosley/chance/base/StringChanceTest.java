package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static com.stevemosley.test.hamcrest.RegexMatcher.matches;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

import com.google.common.primitives.Chars;
import com.stevemosley.chance.ChancePools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class StringChanceTest {

    private final StringChance underTest = new StringChance(aChanceSettings(1234567890).build());

    @Test
    @Repeat(1000)
    public void testCharReturnsACharFromAlphaNumerics() throws Exception {

        // GIVEN

        // WHEN
        char result = underTest.aChar();

        // THEN
        List<Character> values = Chars.asList(ChancePools.ALPHA_NUMERIC_CHARS);
        assertThat(result, isIn(values));

    }

    @Test
    @Repeat(1000)
    public void testCharReturnsACharFromProvidedSet() throws Exception {

        // GIVEN
        char[] charSet = "ABC 123".toCharArray();


        // WHEN
        char result = underTest.aChar(charSet);

        // THEN
        List<Character> values = Chars.asList(charSet);
        assertThat(result, isIn(values));

    }

    @Test
    @Repeat(1000)
    public void testAStringWithBothParamsReturnsCorrectLengthFromPool() throws Exception {

        // GIVEN
        char[] charPool = "ABC 123".toCharArray();

        // WHEN
        String result = underTest.aString(11, charPool);

        // THEN
        assertThat(result.length(), is(11));
        assertThat(result, matches("[ABC 123]{11}"));
    }

    @Test
    @Repeat(1000)
    public void testAStringWithOnlyPoolReturnsRandomLengthFromPool() throws Exception {

        // GIVEN
        char[] charPool = "ABC 123".toCharArray();

        // WHEN
        String result = underTest.aString(charPool);

        // THEN
        assertThat(result, matches("[ABC 123]{5,20}"));
    }

    @Test
    @Repeat(1000)
    public void testAStringWithOnlyLengthReturnsFixedAlphaNumericLength() throws Exception {

        // GIVEN

        // WHEN
        String result = underTest.aString(150);

        // THEN
        assertThat(result, matches("[a-zA-Z0-9]{150}"));
    }

    @Test
    @Repeat(1000)
    public void testAStringWithNoParamsReturnsRandomLengthAlphaNumeric() throws Exception {

        // GIVEN

        // WHEN
        String result = underTest.aString();

        // THEN
        assertThat(result, matches("[a-zA-Z0-9]{5,20}"));
    }

}
