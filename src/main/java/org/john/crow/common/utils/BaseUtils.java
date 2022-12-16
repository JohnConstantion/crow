package org.john.crow.common.utils;

import java.util.Arrays;
import java.util.Base64;

/**
 * 加密
 *
 * @author johnconstantine
 */
public class BaseUtils {

    private BaseUtils() {
    }

    /**
     * @param strValue value to be checked
     * @return Base64 encoder for string value
     */
    public static String getBase64(String strValue) {
        return Arrays.toString(Base64.getEncoder().encode(strValue.getBytes()));
    }
}
