package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import report.ReportHelper;

import java.util.List;

public class BlogPage extends BasePage {
	
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'BUSCA BLOG')]")
    private WebElement buscaBlogSubTitle;

    @FindBy(xpath = "//input[@placeholder = 'Buscar']")
    private WebElement fdBuscar;

    @FindBy(xpath = "//input[@class= 'lupa-form']")
    private WebElement btnBuscar;

    @FindBy(xpath = "//h2/a")
    private List<WebElement> ltResultados;

    public String validarSubTituloBuscaBlog() {
        esperarElementoFicarVisivel(buscaBlogSubTitle);
        return buscaBlogSubTitle.getText();
    }
    
    public void inserirTextoParaBusca(String texto) {
        ReportHelper.inserirLog(Status.INFO, "Preenchendo campo de busca com o valor: " + texto);
        inserirTextoNoElemento(fdBuscar, texto);
    }
    
    public void realizarBusca() {
    	ReportHelper.inserirLog(Status.INFO, "Realizando busca...");
        clicarNoElemento(btnBuscar);
    }

    public boolean obterResultadoSatisfatorio(String texto) {
        ReportHelper.inserirLog(Status.INFO, "Verificando retorno da busca...");
        boolean resultadoEncontrado = false;
        for (WebElement resultado :
                ltResultados) {
            if (resultado.getText().contains(texto)) {
                resultadoEncontrado = true;
                break;
            }
        }
        return resultadoEncontrado;
    }
}
