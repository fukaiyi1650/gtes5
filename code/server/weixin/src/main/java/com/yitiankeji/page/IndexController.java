package com.yitiankeji.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index(HttpSession session) {
        Object openId = session.getAttribute("openId");
        System.out.println(openId);
        return "index";
    }
}
