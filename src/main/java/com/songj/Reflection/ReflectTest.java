package com.songj.Reflection;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.songj.model.dto.ReflectDataDTO;
import com.songj.model.po.ReflectDataOne;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ReflectTest
 * @Description  反射测试
 * @Date 2021/11/11 下午3:58
 * @Created by admin
 */
public class ReflectTest {




    @Test
    public void getClassPath(){
        System.out.println(ReflectDataOne.class);

    }

    @Test
    public void testReflect(){
        String param = "[\n" +
                "    {\n" +
                "        \"tableName\": \"reflect_data_one\",\n" +
                "        \"beanJsonContent\": \"{'id':'12345', 'name':'小明'}\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"tableName\": \"reflect_data_two\",\n" +
                "        \"beanJsonContent\": \"{'id':'12345', 'name':'小明'}\"\n" +
                "    }\n" +
                "]";

        List<ReflectDataDTO> list = new ArrayList<>();
        list = JSONUtil.toList(param, ReflectDataDTO.class);
        Assert.assertTrue("json转化失败", CollectionUtils.isNotEmpty(list));
        List<Object> result = new ArrayList<>();
        for (ReflectDataDTO one : list){
            String tableName = one.getTableName();
            String beanName = StrUtil.upperFirstAndAddPre(StrUtil.toCamelCase(tableName), "");
            System.out.println("tableName" + tableName + " =》=》" + "beanName: " + beanName);

            Object object = ReflectUtil.newInstance("com.songj.model.po." + beanName);

            Object reOne = JSONUtil.toBean(one.getBeanJsonContent(), object.getClass());
            result.add(reOne);
        }
        System.out.println("result: ");
        System.out.println(JSONUtil.toJsonStr(result));
    }




}
