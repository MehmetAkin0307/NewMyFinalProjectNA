package PageObjects;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardResults {
    public By productName= By.cssSelector("p.product-name");
    public WebElement getProduct(){
        return Base.driver.findElement(productName);

    }
}
