package com.yourpackagename.commons.util;

import java.util.Random;

/**
 * Thanks to -
 * http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string-in-java
 *
 * @author: Y Kamesh Rao
 * @created: 4/9/12 8:26 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public class RandomString {

    private static final char[] symbols = new char[36];


    static {
        for (int idx = 0; idx < 10; ++idx)
            symbols[idx] = (char) ('0' + idx);
        for (int idx = 10; idx < 36; ++idx)
            symbols[idx] = (char) ('a' + idx - 10);
    }


    private final Random random = new Random();

    private final char[] buf;


    public RandomString(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }


    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

}