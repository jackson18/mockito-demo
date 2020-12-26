package com.jackson.mockitodemo.lesson03;

import com.jackson.mockitodemo.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author: jacksonqi
 * @create: 2020-12-26 10:54
 **/
@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    @Test
    public void testMock() {
        AccountDao accountDao = Mockito.mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
        System.out.println(accountDao.findAccount("xx", "xx"));
    }

}
