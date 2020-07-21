package com.songj.jsonAbout;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JSONUtil
 * @Description: json转换工具类
 * @Author: Scott S
 * @Date: 2018-11-29 17:12
 * @Version: 1.0
 */
public class JSONUtil {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static Map objectToMap(Object o) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Map map = null;
        try {
            String s = objectMapper.writeValueAsString(o);
            map = objectMapper.readValue(s, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static List<Map<String, Object>> objectToList(Object o) {
        List<Map<String, Object>> list = null;
        try {
            String s = objectMapper.writeValueAsString(o);
            list = objectMapper.readValue(s, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String objectToJSON(Object o) {
        String s = null;
        try {
            s = objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static <T> T JSONToObject(String json, Class<T> classz) {
        T t = null;
        try {
            if (StringUtils.isNotBlank(json) && json.contains("_id")) {
                Map map = objectMapper.readValue(json, Map.class);
                map.remove("_id");
                json = objectToJSON(map);
            }
            t = objectMapper.readValue(json, classz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static String objectToString(Object object){
        String s = null;
        try {
            s = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static Object stringToObject(String s, Class cla){
        Object o = null;
        try {
            o = objectMapper.readValue(s, cla);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
