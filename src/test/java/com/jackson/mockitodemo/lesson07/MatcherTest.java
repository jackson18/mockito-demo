package com.jackson.mockitodemo.lesson07;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * ========================================================
 * 日 期：2020/12/27 上午11:07
 * 作 者：jiabinqi
 * 版 本：1.0.0
 * 类说明：
 * ========================================================
 * 修订日期     修订人    描述
 */
public class MatcherTest {

    @Test
    public void method1() {
        int i = 10;
        assertThat(i, equalTo(10));

        assertThat(i, not(equalTo(20)));

        assertThat(i, is(10));

        assertThat(i, is(not(20)));
    }

    @Test
    public void test2() {
        double price = 2.35;

        // 或
        assertThat(price, either(equalTo(2.35)).or(equalTo(2.53)));

        // 且
        assertThat(price, both(equalTo(2.35)).and(not(equalTo(2.53))));

        assertThat(price, allOf(is(2.35), not(is(1.2)), not(is(2.2))));

        assertThat(Stream.of(1, 2, 3).anyMatch(i -> i > 2), equalTo(true));
        assertThat(Stream.of(1, 2, 3).anyMatch(i -> i > 0), equalTo(true));
    }

    @Test
    public void test3() {
        double price = 2.35;
        assertThat("the double value assert fail", price, either(equalTo(2.35)).or(equalTo(2.53)));
    }

}
