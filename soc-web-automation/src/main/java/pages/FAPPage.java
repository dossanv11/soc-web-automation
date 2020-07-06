package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import java.util.List;

public class FAPPage extends BasePage{

    public FAPPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(), 'FAP')]")
    private WebElement titleFap;

    @FindBy(id = "nomeEmpresa")
    private WebElement txtNomeEmpresa;

    @FindBy(id = "fap")
    private WebElement txtFap;

    @FindBy(xpath = "//div[@class='selectric-scroll']/ul/li")
    private List<WebElement> selectItems;

    @FindBy(xpath = "//div[contains(@class, 'selectric')]")
    private WebElement selectRat;

    @FindBy(id = "projecao")
    private WebElement txtProjecao;

    @FindBy(id = "estimar")
    private WebElement btnEstimar;

    @FindBy(xpath = "//a[text() = 'Saiba mais']")
    private WebElement btnSaibaMais;

    public boolean tituloInicialFap() {
        return elementoEstaVisivel(titleFap);
    }

    public void scrollAteFormulario() {
        scrollParaElemento(btnSaibaMais);
    }

    public void preencherNomeEmpresa(String texto) {
        Helper.inserirLog(Status.INFO, "Preenchendo o campo nome da empresa com o valor: " + texto);
        inserirTextoNoElemento(txtNomeEmpresa, texto);
    }

    public void preencherFap(String texto) {
        Helper.inserirLog(Status.INFO, "Preenchendo o campo FAP com o valor: " + texto);
        inserirTextoNoElemento(txtFap, texto);
    }

    public void escolherRat(String texto) throws InterruptedException {
        Helper.inserirLog(Status.INFO, "Selecionando o valor: " + texto);
        WebElement itemSelecionado = null;
        clicarNoElemento(selectRat);
        Thread.sleep(50);
        for (WebElement item :
                selectItems) {
            if (item.getText().contains(texto)) {
                itemSelecionado = item;
                break;
            }
        }
        itemSelecionado.click();
    }

    public void preencherProjecaoMassaSalarial(String texto) {
        Helper.inserirLog(Status.INFO, "Preenchendo o campo de projeção de massa salarial com o valor: " + texto);
        inserirTextoNoElemento(txtProjecao, texto);
    }

}
