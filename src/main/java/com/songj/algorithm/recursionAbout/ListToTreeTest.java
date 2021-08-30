package com.songj.algorithm.recursionAbout;

import com.alibaba.fastjson.JSON;
import com.songj.bean.Catalog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassNamee: ListToTreeTest
 * @Description: 测试 ListToTree
 * @Author: Scott S
 * @Date: 2020-05-20 10:39
 * @Version: 1.0
 **/
public class ListToTreeTest {
    /**
     * 测试 一共有六个Catalog
     * 其中：name1下面有三个子节点：name2、name3、name4
     *      name2下面有两个子节点：name5、name6
     */
    @Test
    public void ListToMap() throws Exception {
        List<Catalog> list = new ArrayList<>();

        Catalog catalog = new Catalog();
        String flowId = randomUUID();
        catalog.setFlowId(flowId);
        catalog.setName("name1");
        list.add(catalog);

        catalog = new Catalog();
        String flowId2 = randomUUID();
        catalog.setFlowId(flowId2);
        catalog.setName("name2");
        catalog.setParentId(flowId);
        list.add(catalog);

        catalog = new Catalog();
        String flowId3 = randomUUID();
        catalog.setFlowId(flowId3);
        catalog.setName("name3");
        catalog.setParentId(flowId);
        list.add(catalog);

        catalog = new Catalog();
        String flowId4 = randomUUID();
        catalog.setFlowId(flowId4);
        catalog.setName("name4");
        catalog.setParentId(flowId);
        list.add(catalog);

        catalog = new Catalog();
        String flowId5 = randomUUID();
        catalog.setFlowId(flowId5);
        catalog.setName("name5");
        catalog.setParentId(flowId2);
        list.add(catalog);

        catalog = new Catalog();
        String flowId6 = randomUUID();
        catalog.setFlowId(flowId6);
        catalog.setName("name6");
        catalog.setParentId(flowId2);
        list.add(catalog);

        List<Catalog> tree = ListToTree.getTree(list, "flowId");
        System.out.println(JSON.toJSONString(tree));

    /* 装换后输出json样式
    [
      {
        "id" : "ee55dafee60d44a3a143bd3623f29aa9",
        "name" : "name1",
        "children" : [
          {
            "id" : "2e049bdb67624054ad989b511f1b7674",
            "parentId" : "ee55dafee60d44a3a143bd3623f29aa9",
            "name" : "name2",
            "children" : [
              {
                "id" : "9292a15c7a5e4983ac03d10c5fe12a14",
                "name" : "name5",
                "parentId" : "2e049bdb67624054ad989b511f1b7674"
              },
              {
                "id" : "6cd9608726a1438682f239b6017680ca",
                "name" : "name6",
                "parentId" : "2e049bdb67624054ad989b511f1b7674"
              }
            ]
          },
          {
            "id" : "98e90c9e23e445f980c4116bd4c83233",
            "name" : "name3",
            "parentId" : "ee55dafee60d44a3a143bd3623f29aa9"
          },
          {
            "id" : "5e67e73c6aef4eb19b63b4789dcc3486",
            "name" : "name4",
            "parentId" : "ee55dafee60d44a3a143bd3623f29aa9"
          }
        ]
      }
    ]
    */
    }

    protected String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    
}
