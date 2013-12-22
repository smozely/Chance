package com.stevemosley.chance;

import com.google.common.primitives.Chars;

/**
 * This class ...
 */
public final class ChancePools {

    public static final char[] UPPER_CASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final char[] LOWER_CASE_CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final char[] NUMERIC_CHARS = "0123456789".toCharArray();
    public static final char[] ALPHA_NUMERIC_CHARS = Chars.concat(UPPER_CASE_CHARS, LOWER_CASE_CHARS, NUMERIC_CHARS);

}
