package com.zxk.code.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite 运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite 运行啦");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test 运行啦");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test 运行啦");
    }
}
