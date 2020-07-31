package com.yitiankeji.utils;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class TemplateTool {

    @Value("${weixin.appid}")
    private String appid;

    @Autowired
    private WeixinTool weixinTool;

    public void sendMusicMessage(String openId) throws IOException {
        String json = IOUtils.toString(TemplateTool.class.getResourceAsStream("/message/music.json"), StandardCharsets.UTF_8);
        json = json.replaceAll("\\{\\{appid\\}\\}", appid).replaceAll("\\{\\{OPENID\\}\\}", openId);
        System.out.println(json);

        String result = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + weixinTool.getAccessToken()).requestBody(json).ignoreContentType(true).post().body().text();
        System.out.println(result);
    }
}
