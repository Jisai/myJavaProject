package com.songj.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassNamee: TCPServer
 * @Description: tcp服务
 * @Author: Scott S
 * @Date: 2020-09-01 10:36
 * @Version: 1.0
 **/
public class TCPServer {

    public static void main(String[] args) throws Exception{
        //创建socket，并将socket绑定到65000端口上。
        ServerSocket ss = new ServerSocket(65000);
        while (true){
            //死循环，使得socket一直处于等待并处理客户端过来的请求。
            Socket socket = ss.accept();
            //获取客户端的请求信息后，处理相关业务逻辑。
            new LengthCalculator(socket).start();

        }
    }
}
