package com.zsn.file;

import java.io.*;

/**
 * @author zsn
 * @date 2022/10/11 11:34
 */
public class TestInput {


    public static void main(String[] args) throws IOException {
        String urlPath = "C:\\Users\\admin\\Desktop\\idea快捷键.txt";


        //字节流读
        readFileByFileInputStream(urlPath);
        //字节流缓冲读
        readFileByBufferedInputStream(urlPath);

       //字符流读文件InputStreamReader
        readFailByInputStreamReader(urlPath);
        //字符缓冲流,读文件
        readFileByBufferedReader(urlPath);

    }

    /**
     * FileInputStream 字节流读文件
     * 根据文件路径读取文件内容
     *
     * @param urlPath 文件路径
     * @throws IOException io异常
     */
    private static void readFileByFileInputStream(String urlPath) throws IOException {
        // 1.获取文件指定的文件信息
        FileInputStream fileInputStream = new FileInputStream(
                urlPath);
        // 2.将数据读到字节数组里
        byte[] buff = new byte[1024 * 32];
        int length = fileInputStream.read(buff);
        // 3.将字节数据转换为字符串
        // 参数一：带转换的字节数组，参数二：起始位置  参数三：转换的长度
        String info = new String(buff, 0, length);
        System.out.println(info);
    }


    /**
     * 字节流 缓存 读取文件
     *
     * @param urlPath 文件路径
     * @return 文件内容
     * @throws IOException
     */
    public static String readFileByBufferedInputStream(String urlPath) throws IOException {
        final File file = new File(urlPath);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));

        // 一次性取多少个字节
        byte[] bytes = new byte[1024];
        // 用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        // 读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        // 循环取数据
        while ((length = fis.read(bytes)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));
        }
        // 关闭流
        fis.close();
        System.out.println(sb.toString());
        return sb.toString();
    }


    /**
     * 字符流读文件InputStreamReader
     *
     * @param urlPath 文件路径
     * @throws IOException io异常
     */
    private static void readFailByInputStreamReader(String urlPath) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(urlPath);
        InputStreamReader isr = new InputStreamReader(fileInputStream);

        // 字符数组：一次读取多少个字符
        char[] chars = new char[1024];
        // 每次读取的字符数组先append到StringBuilder中
        StringBuilder sb = new StringBuilder();
        // 读取到的字符数组长度，为-1时表示没有数据
        int length;
        // 循环取数据
        while ((length = isr.read(chars)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(chars, 0, length);
        }
        System.out.println(sb);
        // 关闭流
        isr.close();
    }


    /**
     * 字符缓冲流,读文件
     * 根据文件路径读取文件内容
     *
     * @param urlPath 文件路径
     * @throws IOException io 异常
     */
    private static void readFileByBufferedReader(String urlPath) throws IOException {
        File file = new File(urlPath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }


}
