package com.sudha.wsautomation.manager;

import org.testng.annotations.Test;

public class Test3 {

    @Test
    public void testWebService(){
        TestManager testManager = new TestManager();
        testManager.runTest("/Users/sudha/sudha_git/wsautomation/src/main/resources/test3.json");
    }
}
