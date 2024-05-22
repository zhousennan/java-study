package com.zsn.socket.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zsn
 * @date 2022/10/13 17:36
 */
public class TcpServer {
    public static void main(String[] args)throws Exception{
        // 创建服务器ocket对象
        ServerSocket serverSocket = new ServerSocket(9999);
        // 等待客户端连接并获得与客户端关联的Socket对象
        Socket socket = serverSocket.accept();
        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        // 创建字节数组：用来存储读取到客户端发送的数据
        byte[] buf = new byte[1024];
        // 读取客户端发送过来的数据
        int len = in.read(buf);
        System.out.println("len = " + len);
        System.out.println("客户端发送的数据 = " + new String(buf,0,len));

        // 获得字节输出流对象
        OutputStream out = socket.getOutputStream();
        // 往客户端输出数据
        out.write("约你妹".getBytes());
        // 关闭socket
        socket.close();
        // 关闭服务器（在实际开发中，服务器一般不会关闭）
        serverSocket.close();
    }
}
