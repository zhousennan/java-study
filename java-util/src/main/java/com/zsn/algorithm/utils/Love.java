package com.zsn.algorithm.utils;

/**
 * @Author : zhou sen nan
 * @Date : 2022/2/10  10:52
 */
public class Love {
    public static void main(String args[]) {
        int n = 4;
        int i, j, m;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                System.out.print("\033[0;2;0;31;48m" +"*");
            }
            for (j = 1; j <= 2 * n - 1 + (i - 6) * (i - 1); j++) {
                if (i == n)
                    break;
                System.out.print(" ");
            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                if (i == n)
                    break;
                System.out.print("\033[0;2;0;31;48m" +"*");
            }
            if (i == n) {
                for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2 - 1; j++) {
                    System.out.print("\033[0;2;0;31;48m" +"*");
                }
            }
            System.out.println("");
        } // 上面部分
        for (i = 1; i <= n - 2; i++) {
            for (j = 1; j <= 6 + (10 - n) * (n - 1) / 2 - 1 + 6 + (10 - n) * (n - 1) / 2; j++) {
                System.out.print("*");
            }
            System.out.println("");
        } // 中间部分
        m = 6 + (10 - n) * (n - 1) / 2 + 6 + (10 - n) * (n - 1) / 2 - 1;
        for (i = 1; i <= (m - 2 - 3) / 4 + 1; i++) {
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= m + 2 - 4 * i; j++) {
                System.out.print("\033[0;2;0;31;48m" +"*");
            }
            System.out.println("");
        }
        for (j = 1; j <= 2 * ((m - 2 - 3) / 4 + 1); j++)

        {
            System.out.print(" ");
        }
        System.out.print("\033[0;2;0;31;48m" +"*\n");// 下面部分
        System.out.println("\033[0;2;0;31;48m" +"            情情");
       // System.out.println("\033[0;2;0;31;48m" + "显示");
    }

}
