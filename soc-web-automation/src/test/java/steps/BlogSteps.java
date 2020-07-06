package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import factory.DriverFactory;
import pages.BlogPage;

public class BlogSteps {

    private BlogPage blogPage = new BlogPage(DriverFactory.getDriver());

    @Dado("que estou na pagina inicial do blog")
    public void que_estou_na_pagina_inicial_do_blog() throws Throwable {
        Assert.assertTrue(blogPage.validarSubTituloBuscaBlog().equalsIgnoreCase("busca blog"));
    }

    @Quando("eu pesquiso por {string}")
    public void eu_pesquiso_por(String texto) throws Throwable {
        blogPage.inserirTextoParaBusca(texto);
        blogPage.realizarBusca();
    }

    @Entao("verifico que obtive resultado na busca por {string}")
    public void verifico_que_obtive_resultado_na_busca(String texto) throws Throwable {
        Assert.assertTrue(blogPage.obterResultadoSatisfatorio(texto));
    }
    
}
