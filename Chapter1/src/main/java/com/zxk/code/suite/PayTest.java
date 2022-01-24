package com.zxk.code.suite;

import org.testng.annotations.Test;

public class PayTest {

    @Test(enabled = true)
    public void paySuccess(){
        System.out.println("支付宝支付成功");
    }
}
