package testes;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suport.Web;
import static org.junit.Assert.assertEquals;


public class InformacoesUsuarioPageObjectTests {
    private WebDriver navegador;

    @Before
    public void SetUp(){
        navegador = Web.criarChrome();
    }

   @Test
    public void testAdicionarInformacaoAdicionalUsuario(){

       String mensagemExibidaTela =  new LoginPage(navegador).clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarMoreData()
                .clicarNoBotaoAddMoreData()
                .adicionarNovaInformacao("phone", "+551191234-5678");

        assertEquals("Your contact has been added!", mensagemExibidaTela);
    }

    @Test
    public void testRemoverInformacaoAdicionalUsuario(){

        String mensagemExibidaTela =  new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarMoreData()
                .removerContato("+551191234-5678");

        assertEquals("Rest in peace, dear phone!", mensagemExibidaTela);
    }

    @Test
    public void testMudarNomeDoUsuario(){

      new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
               .mudarNome();
    }

    @Test
    public void testDirecionamentoMinhasTarefas(){

        String mensagemExibidaTela = new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .acessarPaginaMinhasTarefas()
                .validarEtapaMyTasks();

        assertEquals("My tasks", mensagemExibidaTela);
    }

   @After
    public void TearDown(){
        navegador.quit();
    }
}
