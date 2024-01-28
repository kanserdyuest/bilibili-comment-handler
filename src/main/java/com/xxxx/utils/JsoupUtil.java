package com.xxxx.utils;

import com.xxxx.pojo.AreaInfo;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * @Author ShaoXikai
 * @Date 2024-01-28
 */
public class JsoupUtil{
    public static Response getResult(String url){
        try {
            Response resp = Jsoup
                    .connect(url)
                    .timeout(4000)
                    .userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15")
                    .ignoreContentType(true)
                    .execute();
            return resp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
