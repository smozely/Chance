package com.stevemosley.chance;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.joda.time.DateTime;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

public class ChanceSettingsBuilder {

    private RandomGenerator generator;

    private long timestamp = DateTime.now().getMillis();

    public static ChanceSettingsBuilder aChanceSettings() {
        return new ChanceSettingsBuilder().withRandomGenerator(new JDKRandomGenerator());
    }

    public static ChanceSettingsBuilder aChanceSettings(long seed) {
        return new ChanceSettingsBuilder().withRandomSeed(seed);
    }

    public static ChanceSettingsBuilder aChanceSettings(RandomGenerator generator) {
        return new ChanceSettingsBuilder().withRandomGenerator(generator);
    }

    private ChanceSettingsBuilder() {
        // Only Construct through factory methods.
    }

    public ChanceSettingsBuilder withRandomGenerator(RandomGenerator generator) {
        this.generator = generator;
        return this;
    }

    public ChanceSettingsBuilder withRandomSeed(long seed) {
        this.generator = new JDKRandomGenerator();
        this.generator.setSeed(seed);
        return this;
    }

    public ChanceSettingsBuilder withCurrentTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ChanceSettingsBuilder withCurrentTimestamp(DateTime timestamp) {
        this.timestamp = timestamp.getMillis();
        return this;
    }

    public ChanceSettings build() {
        return new ChanceSettings(generator, timestamp);
    }
}
