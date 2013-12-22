package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;

import java.text.DateFormatSymbols;

/**
 * This class contains methods for generating random date related values.
 */
public class DateChance extends ChanceSupport {

    enum Month {

        JAN(1),
        FEB(2),
        MAR(3),
        APR(4),
        MAY(5),
        JUN(6),
        JUL(7),
        AUG(8),
        SEP(9),
        OCT(10),
        NOV(11),
        DEC(12);

        private static final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        private final int index;

        Month(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public String getShortName() {
            return dateFormatSymbols.getShortMonths()[index - 1];
        }

        public String getLongName() {
            return dateFormatSymbols.getMonths()[index - 1];
        }
    }

    public DateChance(ChanceSettings settings) {
        super(settings);
    }

    public long timestamp(long min, long max) {
        return randomLongBetween(min, max);
    }

    public long timestamp() {
        return timestamp(0, Long.MAX_VALUE);
    }

    public long timestampFuture() {
        return timestamp(getTimestamp(), Long.MAX_VALUE);
    }

    public long timestampPast() {
        return timestamp(0, getTimestamp());
    }

    private Month randomMonth() {
        return Month.values()[randomIntBetween(0, 11)];
    }

    public int monthInt() {
        return randomMonth().getIndex();
    }

    public String monthShort() {
        return randomMonth().getShortName();
    }

    public String monthLong() {
        return randomMonth().getLongName();
    }

    public int year(int min, int max) {
        return randomIntBetween(min, max);
    }

    public int year() {
        int currentYear = getTimestampDateTime().getYear();
        return year(currentYear, currentYear + 100);
    }

}

