package com.songj.model.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassNamee: Catalog
 * @Description: 目录
 * @Author: Scott S
 * @Date: 2020-05-20 10:43
 * @Version: 1.0
 **/
@Getter
@Setter
public class Catalog implements Serializable {

    /**
     * 唯一编号 uuid
     */
    private String id;

    private String flowId;

    /**
     * 名称
     */
    private String name;

    /**
     * 父节点id
     */
    private String parentId;

    /**
     * 子节点(数据库中不存在该字段，仅用于传输数据使用)
     */
    private List<?> children;



}
