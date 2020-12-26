package com.jackson.mockitodemo.lesson03;

import com.jackson.mockitodemo.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author: jacksonqi
 * @create: 2020-12-26 10:57
 **/
public class MockByAnnotationTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void testMock() {
        System.out.println(accountDao.findAccount("xx", "xx"));
    }

}
