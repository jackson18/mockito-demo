package com.jackson.mockitodemo.lesson03;

import com.jackson.mockitodemo.common.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author: jacksonqi
 * @create: 2020-12-26 11:00
 **/
public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountDao accountDao;

    @Test
    public void testMock() {
        System.out.println(accountDao.findAccount("xx", "xx"));
    }

}
