package com.jackson.mockitodemo.lesson06;

import java.io.Serializable;
import java.util.Collection;

/**
 * ========================================================
 * 日 期：2020/12/27 上午10:41
 * 作 者：jiabinqi
 * 版 本：1.0.0
 * 类说明：
 * ========================================================
 * 修订日期     修订人    描述
 */
public class SimpleService {

    public int method1(int i, String s, Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }

    public void method2(int i, String s, Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }

}
