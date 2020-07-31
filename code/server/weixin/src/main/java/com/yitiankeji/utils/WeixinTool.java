package com.yitiankeji.utils;

import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class WeixinTool {

    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;

    public boolean createMenu() {
        try {
            String menu = IOUtils.toString(WeixinTool.class.getResourceAsStream("/menu.json"), StandardCharsets.UTF_8);
            String result = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + getAccessToken()).ignoreContentType(true).requestBody(menu).post().body().text();
            JSONObject json = JSONObject.fromObject(result);
            return json.get("errcode").equals(0);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMenu() {
        try {
            String result = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + getAccessToken()).ignoreContentType(true).get().body().text();
            JSONObject json = JSONObject.fromObject(result);
            return json.get("errcode").equals(0);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getAccessToken() {
        try {
            String result = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret).ignoreContentType(true).get().body().text();
            JSONObject json = JSONObject.fromObject(result);
            return (String) json.get("access_token");
        } catch (Exception e) {
            return null;
        }
    }

}
