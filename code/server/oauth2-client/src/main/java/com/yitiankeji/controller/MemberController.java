package com.yitiankeji.controller;

import com.yitiankeji.commons.oauth2.session.Session;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/javayh")
public class MemberController {

    @PostMapping("hello")
    @PreAuthorize("hasAnyAuthority('hello')")
    public String hello() {
        return "hello";
    }

    @GetMapping("all")
    public Principal user(Principal principal, OAuth2Authentication authentication) {
        return principal;
    }

    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query(Session session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        count++;
        session.setAttribute("count", count);
        session.setAttribute("user", "zhangsan");

        System.out.println("count: " + count);

        return "具有query权限";
    }
}
