package com.stevemosley.chance;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

public class ChanceSettingsBuilder {

    private Random randy;

    public static ChanceSettingsBuilder aChanceSettings() {
        return aChanceSettings(new SecureRandom());
    }

    public static ChanceSettingsBuilder aChanceSettings(long seed) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
            secureRandom.setSeed(seed);
            return new ChanceSettingsBuilder(secureRandom);
        } catch (NoSuchProviderException | NoSuchAlgorithmException exception) {
            throw new RuntimeException("Error getting SecureRandom instance using 'SHA1PRNG'", exception);
        }
    }

    public static ChanceSettingsBuilder aChanceSettings(Random random) {
        return new ChanceSettingsBuilder(random);
    }

    private ChanceSettingsBuilder(Random random) {
        this.randy = random;
    }

    public ChanceSettingsBuilder withRandom(Random randy) {
        this.randy = randy;
        return this;
    }

    public ChanceSettings build() {
        return new ChanceSettings(randy);
    }
}
