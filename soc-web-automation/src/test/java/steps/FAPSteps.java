package steps;

import factory.DriverFactory;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.FAPPage;
import pages.MenuPage;

public class FAPSteps {

    private FAPPage fapPage = new FAPPage(DriverFactory.getDriver());
    private MenuPage menuPage = new MenuPage(DriverFactory.getDriver());

    @Dado("que estou na tela de FAP")
    public void que_estou_na_tela_de_fap() {
        menuPage.acessarPaginaFap();
        Assert.assertTrue(fapPage.tituloInicialFap());
    }

    @Quando("direciono para o formulario")
    public void direciono_para_o_formulario() {
        fapPage.scrollAteFormulario();
    }

    @Entao("preencho as informacoes {string}, {string}, {string} e {string}")
    public void preencho_as_informacoes_e(String empresa, String fap, String rat, String massaSalarial) throws InterruptedException {
        fapPage.preencherNomeEmpresa(empresa);
        fapPage.preencherFap(fap);
        fapPage.escolherRat(rat);
        fapPage.preencherProjecaoMassaSalarial(massaSalarial);
    }
}
