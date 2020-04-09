//When you change something in properties you don't need to recomple your java project
//It is used to store information which is to be changed frequently
//key=value
//you can get easily values from properties file
//it is sound like changing a part of engine while the engine is running no distrubtion

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties prop;


    public static WebDriver getDriver() throws IOException {
        
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/mehmetakin/IdeaProjects/MyFinalProjectNA/src/test/java/org/example/global.properties");
        //yukarda properties in copy path ini alip buraya yapistirdim.
        prop.load(fis);

       //System.setProperty("webdriver.chrome.driver",
               // System.getProperty("user.dir") + "/Chrome/chromedriver");
            // sol menuye Chrome ekleme proje ismini sag tikliyorum  ==> new ==> Directory
        // Chrome un icini doldurma chromedriver i kopyalayip MyFinalProjectNa icindki crome sayfasina yapistiriyorum.

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(prop.getProperty("url"));
        return driver;

    }
}
