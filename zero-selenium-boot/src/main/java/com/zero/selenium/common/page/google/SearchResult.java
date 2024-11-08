package com.zero.selenium.common.page.google;

import com.zero.selenium.common.annotation.PageFragment;
import com.zero.selenium.common.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment// using custom annotation created; src/main/java/com/demo/seleniumspring/annotation/PageFragment.java
public class SearchResult extends Base {

    @FindBy(css = "div.g")
    private List<WebElement> results;

    public int getCount() {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }
}
