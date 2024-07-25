package com.zsn.test202108;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("输入一个数：");
        Scanner scanner =new Scanner(System.in);
       int total= scanner.nextInt();
            System.out.printf("结果为:"+  find(total));

    }
    public static long find(int number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return find(number - 1) + find(number - 2);
    }
}
