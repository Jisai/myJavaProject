package com.songj.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StringAboutUtil {



    /**
     * BigDecimal 转换成 String 类型，
     * 若原数值精度减少，，采用四舍五入。
     * @param bigDecimalParam  数值
     * @param accuracyNum 小数点后的精度
     * @return 至少返回精度1的字符串
     */
    public static String bigDeciamlToString(BigDecimal bigDecimalParam, int accuracyNum){
        String result = "";
        if(accuracyNum < 1){
            result = new DecimalFormat("#0.0").format(bigDecimalParam);
        }else {
            String pattern = "#0.";
            for(int i = 0; i < accuracyNum; i++){
                pattern += "0";
            }
            result = new DecimalFormat(pattern).format(bigDecimalParam);
        }

        return result;
    }
}
