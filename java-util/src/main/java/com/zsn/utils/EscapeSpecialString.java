package com.zsn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author : zhou sen nan
 * @Date : 2021/12/14  9:50
 */
public class EscapeSpecialString {

    public static void main(String[] args) {

        long a = 00001;

        System.out.println(a);
        System.out.println(Long.parseLong("80000000000"));

        System.out.println(EscapeSpecialString.class);
        String s = "OSS_fsa";
        System.out.println(s.contains("Oss"));

        String str = "789##$";
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m1 = p.matcher(str);
        if(m1.find()){
            CharSequence cs = str;
            int j =0;
            for(int i=0; i< cs.length(); i++){
                String temp = String.valueOf(cs.charAt(i));
                Matcher m2 = p.matcher(temp);
                if(m2.find()){
                    StringBuilder sb = new StringBuilder(str);
                    str = sb.insert(j, "\\").toString();
                    j++;
                }
                j++; //转义完成后str的长度增1
            }
            System.out.println(str);
        }
    }
}
