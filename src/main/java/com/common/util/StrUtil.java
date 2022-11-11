package com.common.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {

    public static String firstCharToUp(String s){
        char[] chars = s.toCharArray();
        chars[0] -=32;
        return String.valueOf(chars);
    }
    public static String firstCharToLow(String s){
        char[] chars = s.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }
    // aa_bb_cc => aaBbCc
    public static String tToe(String s){
        StringBuffer sb = new StringBuffer();
        // 设置想要匹配的字符串
        final String regex = "_[a-z]";
        final String regex2 = "_";
        // 想要匹配的字符串替换成的字符串
        final String subst = "";

        // 设置正则的匹配字符串和匹配模式
        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE);
        // 匹配字符串
        final Matcher matcher = pattern.matcher(s);
        final Pattern pattern2 = Pattern.compile(regex2, Pattern.DOTALL | Pattern.MULTILINE);
        while (matcher.find()){
            // 分组替换字符串
            matcher.appendReplacement(sb,matcher.group().toUpperCase());
        }
        // 拼接分组匹配后的字符
        matcher.appendTail(sb);
        String s1 = sb.toString();
        final Matcher matcher2 = pattern2.matcher(s1);
        int length = sb.length();
        sb.delete(0,length-1);

        final String result = matcher2.replaceAll(subst);
        return result;
    }
    // aaBbCc => aa_bb_cc

    public static String eTot(String s){
        StringBuffer sb = new StringBuffer();
        // 设置想要匹配的字符串
        final String regex = "[A-Z]";
        // 设置正则的匹配字符串和匹配模式
        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            // 分组替换字符串
            matcher.appendReplacement(sb,"_"+matcher.group().toLowerCase(Locale.ROOT));
        }
        // 拼接分组匹配后的字符
        matcher.appendTail(sb);
        String res = sb.toString();
        return res;
    }
}
