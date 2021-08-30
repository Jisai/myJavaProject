package com.songj.algorithm.recursionAbout;

import com.alibaba.fastjson.JSON;
import com.songj.bean.Node;
import com.songj.bean.People;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 递归
 */
public class RecursionLearn {

	public static void main(String[] args) {
		//System.out.println("一列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第30位数是" + resursionMethod01(30));
		resursionMethod02(3,'A','B','C');
	}

	/**
	 * 问题1：一列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第30位数是多少？
	 *
	 * @param index 第几位数从1开始计数。
	 * @return
	 */
	public static int resursionMethod01(int index) {
		if (index <= 2) {
			return 1;
		} else {
			return resursionMethod01(index - 1) + resursionMethod01(index - 2);
		}
	}

	/**【汉诺塔问题】
	 * 要求：输入一个正整数n，表示有n个盘片在第一根柱子上。
	 * 输出操作序列，格式为“移动 t从 x 到 y”。
	 * 每个操作一行，表示把x柱子上的编号为t的盘片挪到柱子y上。
	 * 柱子编号为A，B，C，你要用最少的操作把所有的盘子从A柱子上转移到C柱子上。
	 * @param n 有n个盘片在A柱子上
	 * @param a  A柱子名称
	 * @param b  B柱子名称
	 * @param c  C柱子名称
	 */
	public static void resursionMethod02(int n, char a, char b, char c) {
		if (n == 1)
			System.out.println("移动" + n + "号盘子从" + a + "到" + c);
		else {
			resursionMethod02(n - 1, a, c, b);//把上面n-1个盘子从a借助b搬到c
			System.out.println("移动" + n + "号盘子从" + a + "到" + c);//紧接着直接把n搬动c
			resursionMethod02(n - 1, b, a, c);//再把b上的n-1个盘子借助a搬到c
		}
	}

	@Test
	public void getTree(){
		List<Node> list = getExamples();
		Map<Long, List<Node>> sonMap = list.stream().collect(Collectors.groupingBy(Node::getParentId));
		List<Node> topList = sonMap.get(0L);
		fillTree(topList, sonMap);
		System.out.println(JSON.toJSONString(topList));
	}


	private void fillTree(List<Node> parentNodes, Map<Long, List<Node>> sonMap ){
		if(CollectionUtils.isEmpty(parentNodes)){
			return;
		}
		for(Node parent : parentNodes){
			if(parent == null || parent.getParentId() == null || parent.getParentId().longValue() < 0){
				continue;
			}
			Long parentId = parent.getId();
			List<Node> sonNodes = sonMap.get(parentId);
			if(CollectionUtils.isEmpty(sonNodes)){
				continue;
			}
			parent.setSonNodes(sonNodes);
			fillTree(sonNodes, sonMap);
		}
	}


	public List<Node> getExamples(){
		List<Node> list = new ArrayList<>();
		Node n1 = new Node();
		n1.setId(1L);
		n1.setName("1");
		n1.setParentId(0L);
		list.add(n1);
		Node n2 = new Node();
		n2.setId(2L);
		n2.setName("2");
		n2.setParentId(0L);
		list.add(n2);
		Node n3 = new Node();
		n3.setId(3L);
		n3.setName("3");
		n3.setParentId(0L);
		list.add(n3);
		Node n4 = new Node();
		n4.setId(4L);
		n4.setName("4");
		n4.setParentId(1L);
		list.add(n4);
		Node n5 = new Node();
		n5.setId(5L);
		n5.setName("5");
		n5.setParentId(1L);
		list.add(n5);
		Node n6 = new Node();
		n6.setId(6L);
		n6.setName("6");
		n6.setParentId(1L);
		list.add(n6);
		Node n7 = new Node();
		n7.setId(7L);
		n7.setName("7");
		n7.setParentId(4L);
		list.add(n7);
		Node n8 = new Node();
		n8.setId(8L);
		n8.setName("8");
		n8.setParentId(4L);
		list.add(n8);
		Node n9 = new Node();
		n9.setId(9L);
		n9.setName("9");
		n9.setParentId(8L);
		list.add(n9);
		Node n10 = new Node();
		n10.setId(10L);
		n10.setName("10");
		n10.setParentId(8L);
		list.add(n10);
		Node n11 = new Node();
		n11.setId(11L);
		n11.setName("11");
		n11.setParentId(5L);
		list.add(n11);
		return list;
	}



}
