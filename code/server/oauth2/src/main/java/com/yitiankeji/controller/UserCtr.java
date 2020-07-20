package com.yitiankeji.controller;

import com.yitiankeji.commons.oauth2.annotation.TokenId;
import com.yitiankeji.entity.Result;
import com.yitiankeji.entity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/javayh")
public class UserCtr {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    public Principal user(Principal member) {
        return member;
    }

    /**
     * @param tokenId
     * @return
     * @description 用户注销
     */
    @DeleteMapping(value = "/logout")
    public Result logout(@TokenId String tokenId) {
        Result result = new Result();
        if (consumerTokenServices.revokeToken(tokenId)) {
            result.setCode(ResultCode.SUCCESS.getCode());
            result.setMessage("注销成功");
        } else {
            result.setCode(ResultCode.FAILED.getCode());
            result.setMessage("注销失败");
        }
        return result;
    }
}
