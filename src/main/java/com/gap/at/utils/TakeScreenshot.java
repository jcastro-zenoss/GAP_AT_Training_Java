package com.gap.at.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot{

    public static void takeScreenshot(WebDriver driver, String filePath){

        // Take utils and store as a file format
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  utils to desired location using copyFile //method
            FileUtils.copyFile(src, new File(filePath));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}