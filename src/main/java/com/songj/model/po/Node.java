package com.songj.model.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassNamee: Node
 * @Description: 节点
 * @Author: Scott S
 * @Date: 2020-05-19 19:36
 * @Version: 1.0
 **/
@Getter
@Setter
public class Node implements Serializable {

    private Long id;

    private String name;

    private Long parentId;

    private List<Node> sonNodes;

}
