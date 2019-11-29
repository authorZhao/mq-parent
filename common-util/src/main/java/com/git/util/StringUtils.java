package com.git.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StringUtils {


    /**
     * 判断字符串是不是空
     * @param charSequence
     * @return
     */
    public static boolean isBlank(CharSequence charSequence){
        int length;
        if(charSequence==null||(length=charSequence.length())==0)return true;
        for (int i = 0; i < length; i++) {
            if(!Character.isWhitespace(charSequence.charAt(i)))return false;
        }
        return true;
    }

    /**
     * 驼峰到下划线转换
     * @param param 参数
     * @return
     */
    public static String camel4underline(String param) {
        //匹配A-Z之间的一个大大写字母
        Pattern p = Pattern.compile("[A-Z]");
        if (isBlank(param)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    /**
     * 下划线转驼峰
     * @param param
     * @return
     */
    public static String underline2camel(String param) {
        //匹配下划线小写字母
        Pattern p = Pattern.compile("_[a-z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param.toLowerCase());
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() - i, mc.end() - i, mc.group(0).substring(1).toUpperCase());
            i++;
        }

        return builder.toString();
    }

    /**
     * 字符串变集合，根据特殊符号区分
     * @param arrayString
     * @return
     */
    public static List<String> stringtoListString(String arrayString){
        if(StringUtils.isBlank(arrayString)) return new ArrayList<>();
        if(arrayString.contains("["))arrayString = arrayString.replaceAll("\\[","");
        if(arrayString.contains("]"))arrayString = arrayString.replaceAll("]","");
        return Arrays.stream(arrayString.split(",")).filter(o-> !o.equals("")).collect(toList());
    }


    public static List<Long> stringtoListLong(String arrayString) throws NumberFormatException{
        List<Long> list = new ArrayList<>();
        stringtoListString(arrayString).parallelStream().forEach(o->list.add(Long.valueOf(o)));
        return list;

    }



    public static void main(String... args){
        //String s = "[12,22,455,263,566]";
        String s = "aBRankGoods哈哈Adb";
        String m = "a_asdfas_只能分_aegf";
        //Integer a = Integer.valueOf("");
        //System.out.println(a);
        System.out.println(underline2camel(m));
        System.out.println(camel4underline(s));
    }

}
