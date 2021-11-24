package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        new LoginPage(navegador).clicarSignIn().inserirUser("julio0001", "123456");
    }

   // @After
    public void TearDown(){
        navegador.quit();
    }
}
