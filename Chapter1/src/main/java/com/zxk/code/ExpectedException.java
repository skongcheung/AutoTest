package com.zxk.code;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 什么时候会用到异常测试？
     * 在我们期望的结果是异常的时候
     * 比如：我们传入不合法的参数，程序抛出的异常
     * 也就是说我的预期结果就是这个异常
     */
    //这是一个测试结果会失败的异常测试
//    @Test(expectedExceptions = RuntimeException.class)
//    public void runTimeExceptionFailed(){
//        System.out.println("这是一个失败的异常测试");
//    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的一场异常测试");
        throw new RuntimeException();
    }
}
