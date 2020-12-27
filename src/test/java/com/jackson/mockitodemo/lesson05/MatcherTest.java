package com.jackson.mockitodemo.lesson05;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * ========================================================
 * 日 期：2020/12/27 上午10:27
 * 作 者：jiabinqi
 * 版 本：1.0.0
 * 类说明：
 * ========================================================
 * 修订日期     修订人    描述
 */
public class MatcherTest {

    @Test
    public void basicTest() {
        List<Integer> list = mock(ArrayList.class);
        when(list.get(0)).thenReturn(100);
        assertThat(list.get(0), equalTo(100));
        assertThat(list.get(1), nullValue());
    }

    @Test
    public void testComplex() {
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Child1.class))).thenReturn(100);
        assertThat(foo.function(new Child1()), equalTo(100));

        assertThat(foo.function(new Child2()), equalTo(0));

        reset(foo);

        when(foo.function(Mockito.any(Parent.class))).thenReturn(100);
        assertThat(foo.function(new Child2()), equalTo(100));
    }

    static class Foo {
        int function(Parent parent) {
            return parent.work();
        }
    }

    interface Parent {
        int work();
    }

    class Child1 implements Parent {

        @Override
        public int work() {
            return 1;
        }
    }

    class Child2 implements Parent {

        @Override
        public int work() {
            return 2;
        }
    }

}
