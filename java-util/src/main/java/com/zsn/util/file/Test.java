package com.zsn.util.file;

import java.io.*;

/**
 * @author zsn
 * @date 2022/10/9 11:29
 */
public class Test {
    public static void main(String[] args) throws IOException {

       // read("C:\\Users\\admin\\Desktop\\license-sm.txt");
        //showFile("D:\\新建文件夹\\talents-affirm-server\\src\\main\\java\\com\\bourne\\talentsServer\\controller");


        File file = new File("D:\\新建文件夹\\talents-affirm-server\\src\\main\\java\\com\\bourne\\talentsServer\\service\\impl");
        getAllFile(file);
    }

    public static void read(String path) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            // 1.获取文件指定的文件信息
            fileInputStream = new FileInputStream(
                    path);
            // 2.将数据读到字节数组里
            byte[] buff = new byte[1024*32];
            int length = fileInputStream.read(buff);
            // 3.将字节数据转换为字符串
            // 参数一：带转换的字节数组，参数二：起始位置  参数三：转换的长度
            String info = new String(buff, 0, length);
            System.out.println(info);
            File newfile = new File("C:\\Users\\admin\\Desktop\\fail.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile,true),"UTF-8"));
            String str="\r\n";
            bufferedWriter.write(str);
            bufferedWriter.write(info);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4，关闭流操作
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }


    /*
       定义一个方法,参数传递File类型的目录
       方法中对目录进行遍历
    */
    public static void getAllFile(File dir) throws IOException {
        System.out.println("打印被遍历的目录名称"+dir);
        File[] files = dir.listFiles();
        for (File f : files) {
            //对遍历得到的File对象f进行判断,判断是否是文件夹
            if(f.isDirectory()){
                //f是一个文件夹,则继续遍历这个文件夹
                //我们发现getAllFile方法就是传递文件夹,遍历文件夹的方法
                //所以直接调用getAllFile方法即可:递归(自己调用自己)
                getAllFile(f);
            }else{
                //f是一个文件,直接打印即可
                // 也可以在此判断是否是我们需要搜索的文件
                System.out.println(f);
                read(f.toString());
            }
        }
    }
}
