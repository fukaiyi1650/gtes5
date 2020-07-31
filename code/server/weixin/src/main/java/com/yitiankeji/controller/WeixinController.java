package com.yitiankeji.controller;

import com.yitiankeji.utils.SHA1;
import com.yitiankeji.utils.TemplateTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class WeixinController {

    @Value("${weixin.token}")
    private String token;

    @Autowired
    private TemplateTool templateTool;

    @GetMapping("/wx/main")
    public String main(String signature, String timestamp, String nonce, String echostr) throws NoSuchAlgorithmException {
        // 1）将token、timestamp、nonce三个参数进行字典序排序
        List<String> args = Arrays.asList(token, timestamp, nonce);
        Collections.sort(args);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder result = new StringBuilder();
        args.forEach(result::append);
        String sha1 = SHA1.sha1(result.toString());
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (StringUtils.equalsIgnoreCase(signature, sha1)) {
            return echostr;
        }

        return "none";
//        return StringUtils.equalsIgnoreCase(signature,  getSha1(Stream.of(token, timestamp, nonce).sorted().collect(Collectors.joining("")))) ? echostr : "none";
    }

    @PostMapping(value = "/wx/main")
    public void main(@RequestBody String xml, HttpServletResponse response) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));

        System.out.println(xml);

        XPath xpath = XPathFactory.newInstance().newXPath();
        String MsgType = (String) xpath.evaluate("/xml/MsgType/text()", document, XPathConstants.STRING);
        String ToUserName = (String) xpath.evaluate("/xml/ToUserName/text()", document, XPathConstants.STRING);
        String FromUserName = (String) xpath.evaluate("/xml/FromUserName/text()", document, XPathConstants.STRING);

        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        if ("text".equals(MsgType)) {
            String Content = (String) xpath.evaluate("/xml/Content/text()", document, XPathConstants.STRING);

            writer.write("<xml>");
            writer.write("  <ToUserName><![CDATA[" + FromUserName + "]]></ToUserName>");
            writer.write("  <FromUserName><![CDATA[" + ToUserName + "]]></FromUserName>");
            writer.write("  <CreateTime>1348831860</CreateTime>");
            writer.write("  <MsgType><![CDATA[text]]></MsgType>");
            writer.write("  <Content><![CDATA[服务器回复：" + Content + "]]></Content>");
            writer.write("</xml>");
        } else if ("event".equals(MsgType)) {
            String EventKey = (String) xpath.evaluate("/xml/EventKey/text()", document, XPathConstants.STRING);
            if ("V1001_TODAY_MUSIC".equals(EventKey)) { // 今日歌曲
                templateTool.sendMusicMessage(FromUserName);
            } else if ("V1001_GOOD".equals(EventKey)) { // 赞我们一下
                writer.write("<xml>");
                writer.write("  <ToUserName><![CDATA[" + FromUserName + "]]></ToUserName>");
                writer.write("  <FromUserName><![CDATA[" + ToUserName + "]]></FromUserName>");
                writer.write("  <CreateTime>1348831860</CreateTime>");
                writer.write("  <MsgType><![CDATA[text]]></MsgType>");
                writer.write("  <Content><![CDATA[服务器回复：谢谢对我们的支持，最好能捐款]]></Content>");
                writer.write("</xml>");
            }
        }

        writer.flush();
        writer.close();
    }
}

























