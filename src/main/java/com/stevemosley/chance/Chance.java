package com.stevemosley.chance;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;

import com.stevemosley.chance.base.*;
import org.joda.time.DateTime;

import java.util.Random;

/**
 * TODO
 */
public class Chance {

    private ChanceSettings settings;

    private final Random random;

    private final NumericChance numericChance;

    private final StringChance stringChance;

    private final GuidChance guidChance;

    private final BooleanChance booleanChance;

    private final TimeChance timeChance;

    private final DateChance dateChance;


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

        this.numericChance = new NumericChance(settings);
        this.stringChance = new StringChance(settings);
        this.guidChance = new GuidChance(settings);
        this.booleanChance = new BooleanChance(settings);
        this.timeChance = new TimeChance(settings);
        this.dateChance = new DateChance(settings);
    }

    //// Numeric Chance Wrappers
    public int aInteger() {
        return numericChance.aInteger();
    }

    public int aInteger(int max) {
        return numericChance.aInteger(max);
    }

    public int aInteger(int min, int max) {
        return numericChance.aInteger(min, max);
    }

    public int aNatural() {
        return numericChance.aNatural();
    }

    public long aLong() {
        return numericChance.aLong();
    }

    public float aFloat() {
        return numericChance.aFloat();
    }

    public double aDouble() {
        return numericChance.aDouble();
    }

    //// String Chance Wrappers
    public char aChar() {
        return stringChance.aChar();
    }

    public char aChar(char[] pool) {
        return stringChance.aChar(pool);
    }

    public String aString(int length, char[] pool) {
        return stringChance.aString(length, pool);
    }

    public String aString(int length) {
        return stringChance.aString(length);
    }

    public String aString(char[] pool) {
        return stringChance.aString(pool);
    }

    public String aString() {
        return stringChance.aString();
    }

    //// GUID Chance Wrappers
    public String aGuid() {
        return guidChance.aGuid();
    }

    //// Boolean Chance Wrappers
    public boolean aBool() {
        return booleanChance.aBool();
    }

    public boolean aBool(int likelihood) {
        return booleanChance.aBool(likelihood);
    }

    // Time Chance Wrappers
    public String ampm() {
        return timeChance.ampm();
    }

    public int hour12() {
        return timeChance.hour12();
    }

    public int hour24() {
        return timeChance.hour24();
    }

    public int minute() {
        return timeChance.minute();
    }

    public int second() {
        return timeChance.second();
    }

    public int millisecond() {
        return timeChance.millisecond();
    }

    public DateTime aDateTime() {
        return timeChance.aDateTime();
    }

    //// Date Chance Wrappers
    public int monthInt() {
        return dateChance.monthInt();
    }

    public String monthShort() {
        return dateChance.monthShort();
    }

    public String monthLong() {
        return dateChance.monthLong();
    }

}
