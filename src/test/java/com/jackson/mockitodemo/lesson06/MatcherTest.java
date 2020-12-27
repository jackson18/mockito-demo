package com.jackson.mockitodemo.lesson06;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * ========================================================
 * 日 期：2020/12/27 上午10:42
 * 作 者：jiabinqi
 * 版 本：1.0.0
 * 类说明：
 * ========================================================
 * 修订日期     修订人    描述
 */
@RunWith(MockitoJUnitRunner.class)
public class MatcherTest {

    @Mock
    private SimpleService simpleService;

    @Test
    public void testMethod1() {
        when(simpleService.method1(anyInt(), eq("jackson"), anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(), eq("tom"), anyCollection(), isA(Serializable.class))).thenReturn(200);

        assertThat(simpleService.method1(1, "jackson", Collections.emptyList(), "jackson"), equalTo(100));
        assertThat(simpleService.method1(1, "tom", Collections.emptyList(), "jackson"), equalTo(200));
        assertThat(simpleService.method1(1, "david", Collections.emptyList(), "jackson"), equalTo(0));
    }

    @Test
    public void testMethod2() {
        doNothing().when(simpleService).method2(anyInt(), anyString(), anyCollection(), isA(Serializable.class));

        List<Object> emptyList = Collections.emptyList();
        simpleService.method2(1, "jackson", emptyList, "aaa");
        verify(simpleService, times(1)).method2(1, "jackson", emptyList, "aaa");
        verify(simpleService, times(1)).method2(anyInt(), eq("jackson"), anyCollection(), isA(Serializable.class));
    }

    @After
    public void destroy() {
        Mockito.reset(simpleService);
    }

}
