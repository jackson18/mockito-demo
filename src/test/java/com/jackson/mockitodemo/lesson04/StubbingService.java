package com.jackson.mockitodemo.lesson04;

/**
 * @author: jacksonqi
 * @create: 2020-12-26 17:16
 **/
public class StubbingService {

    public int getInt() {
        System.out.println("getInt call...");
        return 10;
    }

    public String getStr() {
        throw new RuntimeException();
    }

}
