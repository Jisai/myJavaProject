package com.songj.threadAbout.threadLocal;

/**
 * @ClassName: CanvasTL
 * @BelongPackage: com.songj.threadAbout.threadLocal
 * @Description: 画布类（ThreadLocal）
 * @Author: Jisai
 * @Date: 2021/3/9 下午2:13
 * @Version: v1.0
 */
public class CanvasTL {
    private ThreadLocal<String> map = new ThreadLocal();

    public String getContent() {
        return map.get();
    }

    public void setContent(String content) {
        map.set(content);
    }

    public void remove() {
        map.remove();
    }
}
