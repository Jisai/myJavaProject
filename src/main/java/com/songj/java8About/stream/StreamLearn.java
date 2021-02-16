package com.songj.java8About.stream;

import java.util.List;

/**
 * @ClassName: StreamLearn
 * @Description: stream 流 学习练习
 * @Author: Scott S
 * @Date: 2019/5/6 17:17
 * @Version: 1.0
 **/
public interface StreamLearn {


    /**
     * 循环
     **/
    void foreach01();

    /**
     * 循环
     **/
    void foreach02();

    /**
     * 循环
     * 循环输出
     **/
    void foreachPrintln01(List list);

    /**
     * Map的作用就是把 input Stream 的每一个元素，映射成 output Stream 的另外一个元素。
     * 例：转大写。
     **/
    void map01();

    /**
     * Map的作用就是把 input Stream 的每一个元素，映射成 output Stream 的另外一个元素。
     * 例：平方数。
     **/
    void map02();

    void map03();
    /**
     * 获取多层嵌套对象获取底层对象属性
     **/
    void map04();
    
    /** 
     * flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
     * [!!! 一个 Stream 只可以使用一次 !!!]
     * 例：一对多
     **/
    void flatMap01();

    /**
     * 过滤器，把符合条件的筛选出来。
     * 例：将偶数筛选出来，且转换为数组
     **/
    void filter01();


    /**
     * peek 对每个元素执行操作并返回一个新的 Stream。
     *
     **/
    void peek01();

    /**
     * 这个方法的主要作用是把 Stream 元素组合起来。
     * 它提供一个起始值（种子），然后依照运算规则（BinaryOperator），
     * 和前面 Stream 的第一个、第二个、第 n 个元素组合。
     * 从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。
     * 例：sum
     **/
    void reduce01();

    void reduce02();

    /**
     * limit返回Stream的前面 n 个元素
     **/
    void limit01();

    /**
     * skip扔掉Stream的前面 n 个元素
     **/
    void skip01();


    /**
     * 对Stream排序通过sort进行。
     * 对数组排序前可以先对Stream进行各类的map，filter，limit，skip甚至distinct来处理后，再排序。
     **/
    void sort01();



    /**
     *
     **/
    void max01();

    /**
     *
     **/
    void min01();

    /**
     * Stream有 3 个match方法。从语义上说：
     * 1. allMatch： Stream中全部元素符合传入的predicate，返回true。
     * 2. anyMatch: Stream中只要有一个元素符合传入的predicate，返回true。
     * 3. noneMatch: Stream中没有一个元素符合传入非predicate，返回true。
     **/
    void match01();


    /**
     * generate通常英语生产随机数。
     * Stream.generate()默认是串行（相对于parallel而言）但无序（相对于ordered而言）。
     * 由于是无限的，在管道中，必须用limit之类的操作限制Stream的大小。
     **/
    void generate01();

    /**
     * 分组
     **/
    void groupBy01();
    /**
     * 按照条件分组
     **/
    void partitioningBy01();

    /**
     * 分组并排序
     */
    void groupByAndSort01();


}
