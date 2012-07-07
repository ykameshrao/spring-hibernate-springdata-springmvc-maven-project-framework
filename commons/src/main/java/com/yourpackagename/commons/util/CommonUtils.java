/**
 * @filename CommonUtils.java
 * @author Y.Kamesh Rao
 */
package com.yourpackagename.commons.util;

import java.util.Calendar;

/**
 * Class that consists of the commonly used small utilities
 *
 * @author Y.Kamesh Rao
 */
public class CommonUtils {
    /**
     * Returns the current timestamp in timezone independent way
     *
     *
     * @return String form timestamp
     */
    public static String getTimestamp() {
        String created;
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);

        String month = (cal.get(Calendar.MONTH) + 1) + "";
        if (month.length() != 2) {
            month = "0" + month;
        }

        String day = cal.get(Calendar.DAY_OF_MONTH) + "";
        if (day.length() != 2) {
            day = "0" + day;
        }

        String hour = cal.get(Calendar.HOUR_OF_DAY) + "";
        if (hour.length() != 2) {
            hour = "0" + hour;
        }

        String minute = cal.get(Calendar.MINUTE) + "";
        if (minute.length() != 2) {
            minute = "0" + minute;
        }

        String second = cal.get(Calendar.SECOND) + "";
        if (second.length() != 2) {
            second = "0" + second;
        }

        created = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second + "Z";

        return created;
    }


    /**
     * Converts the data to hex representation.
     *
     * @param data The data to be converted
     * @return
     */
    public static String toHex(final byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int intData = (int) data[i] & 0xFF;
            if (intData < 0x10)
                buf.append("0");
            // Display 2 digits per byte i.e. 09
            buf.append(Integer.toHexString(intData));
        }
        return (buf.toString());
    }
}
