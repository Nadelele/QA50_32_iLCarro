package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WDListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(WDListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.error("Exception" + e.toString() + " created in method: " + method.getName());
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
        logger.info("Before getPage: " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        WebDriverListener.super.afterGet(driver, url);
        logger.info("Opened page: " + url);
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        logger.info("Before click: " + element.getTagName());
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        logger.info("After click: " + element.getTagName());
    }
}
