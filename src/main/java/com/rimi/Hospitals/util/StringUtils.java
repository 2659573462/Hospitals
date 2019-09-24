package com.rimi.Hospitals.util;

/**
 * 字符串工具类
 *
 * @author shangzf
 * @date 2019/9/9 10:38
 */
public final class StringUtils {
    private static final String UNLINE = "_";

    private StringUtils() {
    }



    /**
     * 驼峰命名转为下划线命名
     *
     * @param source 驼峰命名的名称
     * @return 带下划线的名称
     */
    public static String humpToUnderline(String source) {
        StringBuilder target = new StringBuilder(source);
        //定位
        int temp = 0;
        if (!source.contains(UNLINE)) {
            for (int i = 0; i < source.length(); i++) {
                if (Character.isUpperCase(source.charAt(i))) {
                    target.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return target.toString().toLowerCase();
    }


    /**
     * 字符串为空
     *
     * @param source 需要判断的字符串
     * @return 结果为空返回true
     */
    public static boolean isEmpty(String source) {
        return source == null || "".equals(source);
    }

    /**
     * 字符串不为空
     *
     * @param source 需要判断的字符串
     * @return 结果为空返回false
     */
    public static boolean isNotEmpty(String source) {
        return !isEmpty(source);
    }

    /**
     * 把带下划线的字符串转换成驼峰命名法
     * 例如: book_name 转换成 bookName
     *
     * @param str 需要转换的字符串 如 book_name
     * @return 转换后的字符串 如 bookName
     */
    public static String underLineToHump(String str) {
        String result = "";
        if (isEmpty(str)) {
            return result;
        }
        // 判断是否包含"_"
        if (!str.contains(UNLINE)) {
            result = str;
            return result;
        }
        StringBuilder sb = new StringBuilder();
        // 把字符串通过截取转换中字符串数组
        String[] arr = str.split(UNLINE);
        for (String s : arr) {
            // 把每个单词的首字母大写
            String aCase = s.substring(0, 1).toUpperCase();
            // 获取剩下的单词
            String s1 = s.substring(1);
            // 拼接
            sb.append(aCase).append(s1);
        }
        // 转换成字符串
        result = sb.toString();
        // 把首字符转成小写
        result = result.substring(0, 1).toLowerCase() + result.substring(1);
        return result;
    }

    public  static String appendDoMethod(String prefix,String source){
        ////判断是否为空
        //if (StringUtils.isEmpty(source)) {
        //    return "";
        //}
        ////创建一个动态的字符串
        //StringBuilder sb =new StringBuilder(prefix);
        ////获取首字母
        //String substring = sb.substring(0, 1);
        ////转换成大写
        //String s = substring.toUpperCase();
        ////获取剩下的
        //String substring1 = source.substring(1);
        ////然后进行拼接
        //String substring11 =sb+s+substring1;
        ////把原有的字符串首字符大写其他不变
        //return substring11;

        // 判断字符串是否为空
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        // 创建一个动态字符串
        StringBuilder sb = new StringBuilder(prefix);
        // 把原有的字符串的首字符大写,其他不变
        // 1.获取首字符
        String firstChar = source.substring(0, 1);
        // 2.首字符大写
        String upperCase = firstChar.toUpperCase();
        // 3.获取剩余的字符串
        String substring = source.substring(1);
        // 4.组合
        sb.append(upperCase).append(substring);
        return sb.toString();
    }
}
