package testes;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suport.Web;

public class InformacoesUsuarioPageObjectTestes {
    private WebDriver navegador;

    @Before
    public void SetUp(){
        navegador = Web.criarChrome();
    }

    @Test
    public void testAdicionarInformacaoAdicionalUsuario(){

        new LoginPage(navegador).clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarNoBotaoAddMoreData()
                .adicionarNovaInformacao(@Param(name = "tipo")String tipo, @Param(name = "contato")String contato, @Param(name = "mensagem")String mensagemEsperada);

    }

   // @After
    public void TearDown(){
        navegador.quit();
    }
}
