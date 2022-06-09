package com.songj.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @ClassNamee: BeanCopyUtil
 * @Description:
 * @Author: Scott S
 * @Date: 2022-05-26 11:20
 * @Version: 1.0
 **/
public class BeanCopyUtil extends BeanUtil {

    /**
     * 集合数据的拷贝
     * @param sources: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        if(CollectionUtils.isNotEmpty(sources)){
            List<T> list = new ArrayList<>(sources.size());
//            for (S source : sources) {
//                T t = target.get();
//                copyProperties(source, t);
//                list.add(t);
//
//            }
            list = sources.parallelStream().map(m ->{
                T t = target.get();
                copyProperties(m, t);
                return t;
            }).collect(Collectors.toList());
            return list;
        }
        return null;
    }


    public static <S, T> List<T> copyListProperties(List<S> sources, Class<T> tClass) {
        if(CollectionUtils.isNotEmpty(sources)){
            return JSONUtil.toList(JSONUtil.toJsonStr(sources), tClass);
        }
        return null;
    }

}
