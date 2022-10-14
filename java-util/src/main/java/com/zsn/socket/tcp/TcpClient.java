package com.zsn.socket.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zsn
 * @date 2022/10/13 17:35
 */
public class TcpClient {

    public static void main(String[] args) throws Exception{
        // 要发送的内容
        String content = "你好TCP服务器端，约吗";
        // 创建Socket对象
        Socket socket = new Socket("127.0.0.1",9999);
        // System.out.println(socket);
        // 获得字节输出流对象
        OutputStream out = socket.getOutputStream();
        // 输出数据到服务器端
        out.write(content.getBytes());

        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        // 创建字节数组：用来存储读取到服务器端数据
        byte[] buf = new byte[1024];
        // 读取服务器端返回的数据
        int len = in.read(buf);
        System.out.println("len = " + len);
        System.out.println("服务器端返回的内容 = " + new String(buf,0,len));

        // 关闭socket对象
        socket.close();
    }
}
