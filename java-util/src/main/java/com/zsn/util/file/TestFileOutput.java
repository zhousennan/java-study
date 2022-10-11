package com.zsn.util.file;

import java.io.*;

/**
 * @author zsn
 * @date 2022/10/11 16:37
 */
public class TestFileOutput {
    public static void main(String[] args) throws IOException {
        String urlPath = "C:\\Users\\admin\\Desktop\\idea快捷键.txt";
        final File file = new File(urlPath);
        //字节流 写文件
        writeFileByOutputStream(file);
        //字节流缓冲写文件
        writeFileByBufferedOutputStream(file);
        //字符流 写文件
        writeFileByOutputStreamWriter(file);
        //字符流缓冲 写文件
        writeFileByBufferedWriter(file);

    }

    /**
     * 字节流 写文件
     * @param file 文件
     * @throws IOException io异常
     */
    public static void writeFileByOutputStream(File file) throws IOException {
        OutputStream os = new FileOutputStream(file, true);

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        // 写入文件
        os.write(string.getBytes());
        // 关闭流
        os.close();
    }

    /**
     * 字节流缓冲写文件
     * @param file 文件
     * @throws IOException io异常
     */
    public static void writeFileByBufferedOutputStream(File file) throws IOException {
        // 缓冲字节流，提高了效率
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(file, true));

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        // 写入文件
        bis.write(string.getBytes());
        // 关闭流
        bis.close();
    }

    /**
     * 字符流 写文件
     * @param file 文件
     * @throws IOException io异常
     */
    public static void writeFileByOutputStreamWriter(File file) throws IOException {
        // OutputStreamWriter可以显示指定字符集，否则使用默认字符集
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        osw.write(string);
        osw.close();
    }

    /**
     * 字符流缓冲 写文件
     * @param file 文件
     * @throws IOException io异常
     */
    public static void writeFileByBufferedWriter(File file) throws IOException {
        // BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new
        // FileOutputStream(file, true), "UTF-8"));
        // FileWriter可以大幅度简化代码
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        bw.write(string);
        bw.close();
    }

}
