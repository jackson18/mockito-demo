package com.jackson.mockitodemo.lesson04;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author: jacksonqi
 * @create: 2020-12-26 16:24
 **/
@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    private List<String> list;

    @Before
    public void init() {
        list = Mockito.mock(ArrayList.class);
    }

    @Test
    public void testHowToUseStubbing() {
        when(list.get(0)).thenReturn("first");
        Assert.assertThat(list.get(0), equalTo("first"));

        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        } catch (Exception e) {
            Assert.assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void testHowToUseStubbingVoidMethod() {
        doNothing().when(list).clear();
        list.clear();
        verify(list, times(1)).clear();

        doThrow(RuntimeException.class).when(list).clear();

        try {
            list.clear();
            fail();
        } catch (Exception e) {
            Assert.assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void testStubbingDoReturn() {
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);
        Assert.assertThat(list.get(0), equalTo("first"));
        Assert.assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void iterateStubbing() {
        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);

        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void stubbingWithAnswer() {
        when(list.get(anyInt())).thenAnswer(k -> {
            Integer index = k.getArgument(0, Integer.class);
            return String.valueOf(index * 10);
        });

        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(10), equalTo("100"));
    }

    @Test
    public void stubbingWithRealCall() {
        StubbingService stubbingService = mock(StubbingService.class);
        when(stubbingService.getStr()).thenReturn("jackson");
        Assert.assertThat(stubbingService.getStr(), equalTo("jackson"));

        when(stubbingService.getInt()).thenCallRealMethod();
        Assert.assertThat(stubbingService.getInt(), equalTo(10));
    }

    @After
    public void destroy() {
        Mockito.reset(list);
    }

}
