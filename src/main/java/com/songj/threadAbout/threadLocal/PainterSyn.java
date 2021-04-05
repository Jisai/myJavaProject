package com.songj.threadAbout.threadLocal;

/**
 * @ClassName: PainterSyn
 * @BelongPackage: com.songj.threadAbout.threadLocal
 * @Description: 画家类（Synchronized）
 * @Author: Jisai
 * @Date: 2021/3/9 下午2:11
 * @Version: v1.0
 */
public class PainterSyn extends Thread{
    private String name;

    private Canvas canvas;

    private String color;

    public PainterSyn(String name, Canvas canvas, String color) {
        this.name = name;
        this.canvas = canvas;
        this.color = color;
    }

    @Override
    public void run() {

        synchronized (this) {
            canvas.setContent(color);
            System.out.println(this.name + "在画板绘制" + canvas.getContent());
        }

    }

}
