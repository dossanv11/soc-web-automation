package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private WebDriver driver;
    private static WebDriverWait wait;
    private static final By ID_COOKIE = By.id("barra-cookie");

    public BasePage(WebDriver driver) {
        try {
            PageFactory.initElements(driver, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);

    }

    public void abrirURL(String url) {
        driver.get(url);
    }

    public void aceitarCookie() {
        esperarElementoFicarVisivelPorBy(ID_COOKIE);
        driver.findElement(ID_COOKIE).click();
    }

    public void esperarElementoFicarVisivelPorBy(By elemento) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    public void esperarElementoFicarVisivel(WebElement elemento) {
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    public void inserirTextoNoElemento(WebElement elemento, String texto) {
        esperarElementoFicarVisivel(elemento);
        elemento.sendKeys(texto);
    }

    public void clicarNoElemento(WebElement elemento) {
        esperarElementoFicarVisivel(elemento);
        elemento.click();
    }

    public void moverParaElemento(WebElement elemento) {
        esperarElementoFicarVisivel(elemento);
        Actions actions = new Actions(driver);
        actions.moveToElement(elemento).build().perform();
    }

    public boolean elementoEstaVisivel(WebElement elemento) {
        try {
            esperarElementoFicarVisivel(elemento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollParaElemento(WebElement elemento) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollBy(0, arguments[0])", elemento.getLocation().y);
    }


}
