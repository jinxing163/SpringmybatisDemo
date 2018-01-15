package com.ssm.baseTools;

import org.springframework.util.StringUtils;

/**
 * @author JinXing
 * @date 2018/1/8 10:03
 */
public class StringUtilsTools {

    public static Boolean isEmpty(Object obj) {

        if (obj == null) {
            return true;
        } else {

            if (obj instanceof String) {
                String str= (String) obj;
                if (StringUtils.isEmpty(str.trim())) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isEmpty(" "));
    }

}
