package com.stevemosley.chance;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.joda.time.DateTime;

import java.util.Random;

/**
 * TODO This class ...
 */
public class ChanceSettings {

    private final RandomGenerator generator;

    private final RandomDataGenerator dataGenerator;

    private final long timestamp;

    private final DateTime timestampDateTime;

    ChanceSettings(RandomGenerator randy, long timestamp) {
        this.generator = randy;
        this.dataGenerator = new RandomDataGenerator(randy);
        this.timestamp = timestamp;
        this.timestampDateTime = new DateTime(timestamp);
    }

    public RandomGenerator getGenerator() {
        return generator;
    }

    public RandomDataGenerator getDataGenerator() {
        return dataGenerator;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public DateTime getTimestampDateTime() {
        return timestampDateTime;
    }
}
