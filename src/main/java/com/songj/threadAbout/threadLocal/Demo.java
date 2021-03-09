package com.songj.threadAbout.threadLocal;

/**
 * @ClassName: Demo
 * @BelongPackage: com.songj.threadAbout.threadLocal
 * @Description:
 * https://juejin.cn/post/6893490343661174797
 * @Author: Jisai
 * @Date: 2021/3/9 下午2:12
 * @Version: v1.0
 */
public class Demo {
    public static void main(String[] args) {

        // 创建画布
        Canvas canvas = new Canvas();

        Painter painter1 = new Painter("小强", canvas, "红色");
        Painter painter2 = new Painter("旺财", canvas, "黄色");
        Painter painter3 = new Painter("狗蛋", canvas, "蓝色");

        painter1.start();
        painter2.start();
        painter3.start();



        CanvasTL canvasTL = new CanvasTL();
        PainterTL painterTL1 = new PainterTL("小强TL", canvasTL, "红色");
        PainterTL painterTL2 = new PainterTL("旺财TL", canvasTL, "黄色");
        PainterTL painterTL3 = new PainterTL("狗蛋TL", canvasTL, "蓝色");

        painterTL1.start();
        painterTL2.start();
        painterTL3.start();
    }

}
