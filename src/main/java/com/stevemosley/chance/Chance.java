package com.stevemosley.chance;

import static com.google.common.base.Preconditions.*;
import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;

import com.google.common.primitives.Chars;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.Random;
import java.util.UUID;

/**
 * TODO
 */
public class Chance {

    public static final char[] UPPER_CASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final char[] LOWER_CASE_CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final char[] NUMERIC_CHARS = "0123456789".toCharArray();
    public static final char[] ALPHA_NUMERIC_CHARS = Chars.concat(UPPER_CASE_CHARS, LOWER_CASE_CHARS, NUMERIC_CHARS);

    private ChanceSettings settings;

    private final Random random;

    /**
     * Construct with a internally created random.
     */
    public Chance() {
        this(aChanceSettings().build());
    }

    /**
     * Construct with a seed value, useful for generating the
     * same data repeatedly.
     *
     * @param seed - the seed value
     */
    public Chance(long seed) {
        this(aChanceSettings(seed).build());
    }

    /**
     * Construct with a Random instance, useful for
     *
     * @param random - the random to use
     */
    public Chance(Random random) {
        this(aChanceSettings(random).build());
    }

    public Chance(ChanceSettings settings) {
        this.settings = settings;
        this.random = settings.getRandom();
    }

    /**
     * Return a guid string
     */
    public String aGuid() {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;  /* clear version        */
        randomBytes[6] |= 0x40;  /* set to version 4     */
        randomBytes[8] &= 0x3f;  /* clear variant        */
        randomBytes[8] |= 0x80;  /* set to IETF variant  */

        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++)
            msb = (msb << 8) | (randomBytes[i] & 0xff);
        for (int i = 8; i < 16; i++)
            lsb = (lsb << 8) | (randomBytes[i] & 0xff);

        return new UUID(msb, lsb).toString();
    }

    public boolean aBool() {
        return random.nextBoolean();
    }

    public boolean aBool(int likelihood) {
        checkArgument(likelihood > 0 && likelihood < 100, "likelihood must be between 0 and 100 (exclusive)");

        int random = randomIntBetween(1, 100);
        return !(random > likelihood);
    }

    public int aNatural() {
        return random.nextInt(Integer.MAX_VALUE);
    }

    public int aInteger() {
        return random.nextInt();
    }

    public long aLong() {
        return random.nextLong();
    }

    public float aFloat() {
        return random.nextFloat();
    }

    public double aDouble() {
        return random.nextDouble();
    }

    public char aChar() {
        return aChar(ALPHA_NUMERIC_CHARS);
    }

    public char aChar(char[] pool) {
        return pool[random.nextInt(pool.length)];
    }

    public String aString(int length, char[] pool) {
        char[] resultChars = new char[length];

        for (int i = 0; i < resultChars.length; i++) {
            resultChars[i] = aChar(pool);
        }

        return new String(resultChars);
    }

    public String aString(int length) {
        return aString(length, ALPHA_NUMERIC_CHARS);
    }

    public String aString(char[] pool) {
        return aString(randomIntBetween(5, 20), pool);
    }

    public String aString() {
        return aString(randomIntBetween(5, 20), ALPHA_NUMERIC_CHARS);
    }

    public DateTime aDateTime() {
        return new DateTime(aLong());
    }

    public DateTime aDateTimeInTheFuture() {
        return null;
    }

    private int randomIntBetween(int min, int max) {
        // nextInt is exclusive of the top value,
        // so add 1 to make it inclusive
        return random.nextInt((max - min) + 1) + min;
    }
}
