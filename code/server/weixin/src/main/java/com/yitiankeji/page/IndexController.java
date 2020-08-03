package com.yitiankeji.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping({"/wx", "/wx/index"})
    public String index(HttpSession session) {
        Object openId = session.getAttribute("openId");
        System.out.println(openId);
        return "index";
    }

    @GetMapping("/wx/openid")
    public String getOpenId(HttpSession session) {
        return (String) session.getAttribute("openId");
    }
}
