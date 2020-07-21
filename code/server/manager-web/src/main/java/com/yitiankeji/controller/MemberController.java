package com.yitiankeji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @GetMapping("/member/list")
    public String list() {
        return "/member/list";
    }

    @GetMapping("/member/add")
    public String add() {
        return "/member/add";
    }

    @GetMapping("/member/edit")
    public String add(Integer id) {
        return "/member/edit";
    }

    @ResponseBody
    @PostMapping("/member/page")
    public String page() {
        return "{}";
    }
}
