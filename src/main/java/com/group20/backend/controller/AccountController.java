package com.group20.backend.controller;

import com.group20.Request;
import com.group20.Response;
import com.group20.backend.model.Account;
import com.group20.backend.service.AccountService;
import com.group20.backend.service.AccountServiceImpl;
import com.group20.utils.ResultUtil;

/**
 * account controller
 *
 * @author Ni Xiang
 */
public class AccountController implements Controller {
    private final AccountService accountService = new AccountServiceImpl();

    @Override
    public Response requestHandler(Request request) {
        String url = request.getUrl();
        if (url.contains("selectAccount")) {
            return accountService.selectAccountByUserId((Integer) request.getBody());
        } else if (url.contains("createAccount")) {
            return accountService.createAccount((Account) request.getBody());
        } else if (url.contains("removeAccount")) {
            return accountService.removeAccount((Account) request.getBody());
        }
        return ResultUtil.fail("无效url");
    }
}
