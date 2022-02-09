package com.songj.agent;

import com.songj.model.po.Employee;
import org.junit.Test;

/**
 * @ClassNamee: AgentTest
 * @Description:
 * @Author: Scott S
 * @Date: 2020-05-12 16:09
 * @Version: 1.0
 **/
public class AgentTest {


    @Test
    public void setFieldValueByName(){
        String testStr = "{'id':403,'name':'zhangSan','level':'1','isQuit':'true'}";
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(testStr);
        Employee employee = (Employee) net.sf.json.JSONObject.toBean(jsonObject,Employee.class);
        System.out.println(employee);
        System.out.println("employee name is " + employee.getName());
        AgentUtil.setFieldValueByName(employee, "name", "liSi");
        System.out.println("employee set name is " + employee.getName());

    }

}
