package com.watermelon.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;


// xss非法标签过滤
public class XssFilterUtil {

    /**
     * 使用自带的basicWithImages 白名单
     * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
     * strike,strong,sub,sup,u,ul,img
     * 以及a标签的href,img标签的src,align,alt,height,width,title属性
     */
    private static final Whitelist whitelist = Whitelist.basicWithImages();

    /** 配置过滤化参数,不对代码进行格式化 */
    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);

    public static String clean(String content) {
        return Jsoup.clean(content, "", whitelist, outputSettings);
    }
}