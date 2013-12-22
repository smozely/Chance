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


}

