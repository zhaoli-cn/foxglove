package com.zhaol.common.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试工具类
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/21 13:46
 */
public class TestUtil {

    public static void main(String[] args) {
        List<String> urls = getUrls();
        Set<String> phones = new HashSet<>();
        int i =1;
        for(String url : urls) {
            //System.out.println("第"+i+"页");
            phones.addAll(getInfo(url));
            i++;
        }
        System.out.println(phones.size());
    }

    private static List<String> getUrls() {
        int total = 15;
        List<String> urls = new ArrayList<>();
        String pre = "https://shop.10086.cn/list/134_200_200_";
        String end = "_0_0_0.html?p=";
        //String pre = "https://shop.10086.cn/list/134_200_762_";
        //String end = "_0_0_0.html?p=";
        for(int i=1; i<=total; i++) {
            String url = pre+i+end+i;
            urls.add(url);
        }
        return urls;
    }

    private static Set<String> getInfo(String url) {
        String data = HttpUtil.get(url,new HashMap<>());
        Set<String> phones = getPhone(data);
        phones = filter(phones);
        phones.stream().forEach(System.out::println);
        return phones;
    }

    private static Set<String> filter(Set<String> phones) {
        if(phones.isEmpty()) {
            return phones;
        }
        Set<String> r = new HashSet<>();
        for(String phone : phones) {
            if(phone.indexOf("4")>0) {
                continue;
            }
            if(phone.indexOf("7") > 0) {
                //continue;
            }
            if((phone.lastIndexOf("8") == 10) || (phone.lastIndexOf("6") == 10)) {
                r.add(phone);
            }
        }
        return r;
    }

    private static Set<String> getPhone(String content) {
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        String pex = "(?<!\\d)(?:(?:1[3578]\\d{9})|(?:861[358]\\d{9}))(?!\\d)";
        Set<String> result = new HashSet<>();
        final Pattern pattern = Pattern.compile(pex);
        Matcher matcher = pattern.matcher(content);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
            String phone = bf.toString();
            String [] phoneSplit = phone.split(",");
            for(String telephone : phoneSplit){
                boolean isTruePhone = Pattern.matches(regex, telephone);
                if(isTruePhone){
                    result.add(telephone);
                }
            }
        }
        return result;
    }
}
