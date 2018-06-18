package com.sudha.wsautomation.manager;

import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void testWebService(){
        TestManager testManager = new TestManager();
        testManager.runTest("/Users/sudha/sudha_git/wsautomation/src/main/resources/test1.json");
    }
}
