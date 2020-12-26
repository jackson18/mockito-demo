package com.jackson.mockitodemo.lesson03;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author: jacksonqi
 * @create: 2020-12-26 11:02
 **/
public class DeepMockTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Lesson03Service lesson03Service;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMock() {
        System.out.println(lesson03Service.getLesson03().foo());
    }

}
