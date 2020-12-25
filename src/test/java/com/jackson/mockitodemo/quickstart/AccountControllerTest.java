package com.jackson.mockitodemo.quickstart;

import com.jackson.mockitodemo.common.Account;
import com.jackson.mockitodemo.common.AccountController;
import com.jackson.mockitodemo.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * ========================================================
 * 日 期：2020/12/25 下午1:43
 * 作 者：jiabinqi
 * 版 本：1.0.0
 * 类说明：
 * ========================================================
 * 修订日期     修订人    描述
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    private HttpServletRequest request;

    private AccountDao accountDao;

    private AccountController accountController;

    @Before
    public void init() {
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountDao = Mockito.mock(AccountDao.class);
        this.accountController = new AccountController(accountDao);
    }

    @Test
    public void testLoginSucess() {
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("jackson");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);

        String result = accountController.login(request);
        assertThat(result, equalTo("/index"));
    }

    @Test
    public void testLoginFail() {
        Mockito.when(request.getParameter("username")).thenReturn("jackson");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);

        String result = accountController.login(request);
        assertThat(result, equalTo("/login"));
    }

    @Test
    public void testLoginException() {
        Mockito.when(request.getParameter("username")).thenReturn("jackson");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenThrow(RuntimeException.class);

        String result = accountController.login(request);
        assertThat(result, equalTo("/505"));
    }

}
