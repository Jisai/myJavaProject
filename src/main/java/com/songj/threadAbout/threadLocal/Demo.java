package com.songj.threadAbout.threadLocal;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Demo
 * @BelongPackage: com.songj.threadAbout.threadLocal
 * @Description: https://juejin.cn/post/6893490343661174797
 * @Author: Jisai
 * @Date: 2021/3/9 下午2:12
 * @Version: v1.0
 */
public class Demo {

    @Test
    public void test() {

        // 在多线程访问同一个资源(画布)的情况下，输出结果出现并发问题。
        testSimple();

        //一种是在 run 方法中加入 synchronized 同步代码块
        testSyn();

        //另一种是使用 ThreadLocal 改造 Canvas 类型。
        testTL();
    }

    public void testSimple() {
        Canvas canvas = new Canvas();
        Painter painter1 = new Painter("红笔", canvas, "红色");
        Painter painter2 = new Painter("黄笔", canvas, "黄色");
        Painter painter3 = new Painter("蓝笔", canvas, "蓝色");
        painter1.start();
        painter2.start();
        painter3.start();
    }

    public void testSyn() {
        Canvas canvas = new Canvas();
        PainterSyn painterSyn1 = new PainterSyn("红笔Syn", canvas, "红色");
        PainterSyn painterSyn2 = new PainterSyn("黄笔Syn", canvas, "黄色");
        PainterSyn painterSyn3 = new PainterSyn("蓝笔Syn", canvas, "蓝色");
        painterSyn1.start();
        painterSyn2.start();
        painterSyn3.start();
    }

    public void testTL() {
        CanvasTL canvasTL = new CanvasTL();
        PainterTL painterTL1 = new PainterTL("红笔TL", canvasTL, "红色");
        PainterTL painterTL2 = new PainterTL("黄笔TL", canvasTL, "黄色");
        PainterTL painterTL3 = new PainterTL("蓝笔TL", canvasTL, "蓝色");
        painterTL1.start();
        painterTL2.start();
        painterTL3.start();
    }

}
