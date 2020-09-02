package com.songj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassNamee: LengthCalculator
 * @Description: 业务逻辑
 * @Author: Scott S
 * @Date: 2020-09-01 10:45
 * @Version: 1.0
 **/
public class LengthCalculator extends Thread {

    private Socket socket;

    public LengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            //获取socket输出流
            OutputStream os = socket.getOutputStream();
            //获取socket输入流
            InputStream is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            //buff主要用来读取输入的内容，存在byte数组中；ch主要用来读书数组的长度。
            ch = is.read(buff);
            //将接收流的buff转换成字符串，这里获取的内容是客户端发过来的字符串参数。
            String content = new String(buff, 0, ch);
            System.out.println(content);
            //往输出流写入活得的字符串长度，回发给客户端。
            os.write(String.valueOf(content.length()).getBytes());
            //不要忘记关闭输入输出流，一级socket。
            os.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
