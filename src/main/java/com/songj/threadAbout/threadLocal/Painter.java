package com.songj.threadAbout.threadLocal;

/**
 * @ClassName: Painter
 * @BelongPackage: com.songj.threadAbout.threadLocal
 * @Description: 画家类
 * @Author: Jisai
 * @Date: 2021/3/9 下午2:11
 * @Version: v1.0
 */
public class Painter extends Thread{
    private String name;

    private Canvas canvas;

    private String color;

    public Painter(String name, Canvas canvas, String color) {
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
