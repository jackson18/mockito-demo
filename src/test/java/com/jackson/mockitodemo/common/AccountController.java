package com.jackson.mockitodemo.common;

import javax.servlet.http.HttpServletRequest;

/**
 * ========================================================
 * 日 期：2020/12/25 下午1:40
 * 作 者：jiabinqi
 * 版 本：1.0.0
 * 类说明：
 * ========================================================
 * 修订日期     修订人    描述
 */
public class AccountController {

    private AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Account account = accountDao.findAccount(username, password);
            if (account == null) {
                return "/login";
            } else {
                return "/index";
            }
        } catch (Exception e) {
            return "/505";
        }
    }

}
