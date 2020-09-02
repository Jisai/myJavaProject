package com.songj.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassNamee: TCPClient
 * @Description:
 * @Author: Scott S
 * @Date: 2020-09-01 11:42
 * @Version: 1.0
 **/
public class TCPClient {

    public static void main(String[] args) throws Exception {
        //创建socket，并指定连接的是本机端口号是65000 的服务器socket。
        Socket socket = new Socket("127.0.0.1", 65000);
        //获得输出流
        OutputStream os = socket.getOutputStream();
        //获得输入流
        InputStream is = socket.getInputStream();
        //将要传递给server的字符串参数转化为byte数组，并将数组写入到输出流中。
        os.write(new String("hello world").getBytes());
        int ch = 0;
        byte[] buff = new byte[1024];
        //buff主要用来读取输入的内容，存在byte数组中；ch主要用来读书数组的长度。
        ch = is.read(buff);
        //将接收流的buff转换成字符串，这里获取的内容是客户端发过来的字符串参数。
        String content = new String(buff, 0, ch);
        System.out.println(content);
        //不要忘记关闭输入输出流，一级socket。
        os.close();
        is.close();
        socket.close();
    }
}
