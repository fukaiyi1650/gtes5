package com.yitiankeji.interceptor;

import com.yitiankeji.utils.WeixinTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.net.URLEncoder;

@Component
public class WeiXinOauth2Interceptor implements HandlerInterceptor {

    @Value("${weixin.appid}")
    private String appid;

    @Autowired
    private WeixinTool weixinTool;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/wx/")) {
            return true;
        }

        HttpSession session = request.getSession();

        String openId = (String) session.getAttribute("openId");
        if (openId != null) {
            return true;
        }

        String code = request.getParameter("code");
        if (code != null) {
            // 处理openId
            openId = weixinTool.getOpenId(code);
            session.setAttribute("openId", openId);
            return true;
        }

        int port = request.getServerPort();
        if (port != 80) {
            PrintWriter writer = response.getWriter();
            writer.write("服务器必须是80端口");
            writer.flush();
            writer.close();
            return false;
        }

        String url = request.getScheme() + "://" + request.getServerName() + request.getContextPath() + request.getRequestURI();
        String queryString = request.getQueryString();
        if (StringUtils.isNoneBlank(queryString)) {
            url += "?" + queryString;
        }
        url = URLEncoder.encode(url, "UTF-8");
        response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + url + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
        return false;
    }
}

//http://g5mzfh.natappfree.cc/index.html