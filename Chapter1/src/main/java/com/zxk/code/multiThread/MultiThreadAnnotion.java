package com.zxk.code.multiThread;

import org.testng.annotations.Test;

public class MultiThreadAnnotion {

    //invocation 调用
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread id: %s%n", Thread.currentThread().getId());
    }
}
