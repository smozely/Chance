package com.stevemosley.chance;

import static com.google.common.base.Preconditions.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * TODO
 */
public class Chance {

    private final Random random;

    /**
     * Construct with a internally created random.
     */
    public Chance() {
        this(new SecureRandom());
    }

    /**
     * Construct with a seed value, useful for generating the
     * same data repeatedly.
     *
     * @param seed - the seed value
     */
    public Chance(long seed) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
            secureRandom.setSeed(seed);
            this.random = secureRandom;
        } catch(NoSuchProviderException | NoSuchAlgorithmException exception) {
            throw new RuntimeException("Error getting SecureRandom instance using 'SHA1PRNG'", exception);
        }
    }

    /**
     * Construct with a Random instance, useful for
     *
     * @param random - the random to use
     */
    public Chance(Random random) {
        this.random = random;
    }

    /**
     * Return a guid string
     */
    public String guid() {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        randomBytes[6]  &= 0x0f;  /* clear version        */
        randomBytes[6]  |= 0x40;  /* set to version 4     */
        randomBytes[8]  &= 0x3f;  /* clear variant        */
        randomBytes[8]  |= 0x80;  /* set to IETF variant  */

        long msb = 0;
        long lsb = 0;
        for (int i=0; i<8; i++)
            msb = (msb << 8) | (randomBytes[i] & 0xff);
        for (int i=8; i<16; i++)
            lsb = (lsb << 8) | (randomBytes[i] & 0xff);

        return new UUID(msb, lsb).toString();
    }

    public boolean bool() {
        return random.nextBoolean();
    }

    public boolean bool(int likelihood) {
        checkArgument(likelihood > 0 && likelihood < 100, "likelihood must be between 0 and 100 (exclusive)");

        int random = randomIntBetween(1, 100);
        return !(random > likelihood);
    }

    public int natural() {
        return random.nextInt(Integer.MAX_VALUE);
    }

    public int integer() {
        return random.nextInt();
    }

    private int randomIntBetween(int min, int max) {
        // nextInt is exclusive of the top value,
        // so add 1 to make it inclusive
        return random.nextInt((max - min) + 1) + min;
    }
}
