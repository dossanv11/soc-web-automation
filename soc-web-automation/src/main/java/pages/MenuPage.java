package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.ReportHelper;

public class MenuPage extends BasePage{

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(text(), 'Recursos')]")
    private WebElement mnRecursos;

    @FindBy(xpath = "//abbr[text() = 'FAP']")
    private WebElement sbFAP;

    public void acessarPaginaFap() {
        ReportHelper.inserirLog(Status.INFO, "Acessando a página FAP...");
        moverParaElemento(mnRecursos);
        clicarNoElemento(sbFAP);
    }
}
