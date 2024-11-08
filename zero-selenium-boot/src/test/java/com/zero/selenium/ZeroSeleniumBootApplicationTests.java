package com.zero.selenium;

import com.zero.selenium.common.page.google.GooglePage;
import com.zero.selenium.common.util.ScreenShotUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;

@SpringBootTest
class ZeroSeleniumBootApplicationTests {

    @Autowired
    private GooglePage googlePage;

    @Lazy // only create the object when needed
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void GoogleTest() throws IOException, InterruptedException {
        this.googlePage.goToGooglePage();
        Assertions.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");
        Assertions.assertTrue(this.googlePage.getSearchResult().isAt());
        Assertions.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        System.out.println("Number of Results: " + this.googlePage.getSearchResult().getCount());
        // wait 3 seconds
        // Thread.sleep(3000);
        //take screenshot
        this.screenShotUtil.takeScreenShot("Test.png");
        this.googlePage.close();
    }

}
