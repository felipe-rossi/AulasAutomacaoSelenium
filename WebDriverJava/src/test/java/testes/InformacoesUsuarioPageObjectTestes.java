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
import pages.MePage;
import suport.Web;
import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectTestes.csv")
public class InformacoesUsuarioPageObjectTestes {
    private WebDriver navegador;

    @Before
    public void SetUp(){
        navegador = Web.criarChrome();
    }

   /* @Test
    public void testAdicionarInformacaoAdicionalUsuario(@Param(name = "tipo")String tipo, @Param(name = "contato")String contato, @Param(name = "mensagem")String mensagemEsperada){

       String mensagemExibidaTela =  new LoginPage(navegador).clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarMoreData()
                .clicarNoBotaoAddMoreData()
                .adicionarNovaInformacao(tipo, contato);

        assertEquals(mensagemEsperada, mensagemExibidaTela);
    }

    @Test
    public void testRemoverInformacaoAdicionalUsuario(@Param(name = "contato")String contato, @Param(name = "mensagem")String mensagemEsperada){

        String mensagemExibidaTela =  new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarMoreData()
                .removerContato(contato);

        assertEquals(mensagemEsperada.replace(".", ","), mensagemExibidaTela);
    }*/

    @Test
    public void testMudarNomeDoUsuario(){

      new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
               .mudarNome();

    }

   @After
    public void TearDown(){
        navegador.quit();
    }
}
