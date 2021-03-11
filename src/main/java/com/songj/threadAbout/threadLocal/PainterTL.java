package com.songj.threadAbout.threadLocal;

/**
 * @ClassName: PainterTL
 * @BelongPackage: com.songj.threadAbout.threadLocal
 * @Description: 画家类（ThreadLocal）
 * @Author: Jisai
 * @Date: 2021/3/9 下午2:11
 * @Version: v1.0
 */
public class PainterTL extends Thread{
    private String name;

    private CanvasTL canvas;

    private String color;

    public PainterTL(String name, CanvasTL canvas, String color) {
        this.name = name;
        this.canvas = canvas;
        this.color = color;
    }

    @Override
    public void run() {
        canvas.setContent(color);
        System.out.println(this.name + "在画板绘制" + canvas.getContent());

    }

}
