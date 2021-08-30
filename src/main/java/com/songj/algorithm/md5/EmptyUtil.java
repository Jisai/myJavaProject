package com.songj.algorithm.md5;

import java.util.List;

/**
 * @ClassName: EmptyUtil
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2019/6/26 18:57
 * @Version: 1.0
 **/
public class EmptyUtil {
    private EmptyUtil() {
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof List) {
            return ((List)obj).isEmpty();
        } else {
            return obj instanceof String && ((String) obj).trim().equals("");
        }
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
