package testes;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Generator;
import suport.Screenshot;
import suport.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")

public class InformacoesUsuarioTest {
    public WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        //Chamando a classe para criação de um novo navegador
        navegador = Web.criarChrome();

    }

   @Test
    public void testAdcionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,@Param(name="contato")String contato,@Param(name="mensagem")String mensagemEsperada){



    }

    @Test
    public void removerUmContatoDeUmUsuario(){
        //Idetinficar qual contato vc quer excluir pelo XPath(+551191234-5678) e clicar no botão para excluir o contato
        navegador.findElement(By.xpath("//span[text()=\"+551191234-5678\"]/following-sibling::a")).click();

        //confirmar a janela Javascript
        navegador.switchTo().alert().accept();

        //Validar se o texto de exclusão foi exibido corretamente: "Rest in peace, dear phone!"
        WebElement divDaMensagem = navegador.findElement(By.id("toast-container"));
        String mensagemExibida = divDaMensagem.getText();
        assertEquals("Rest in peace, dear phone!", mensagemExibida);

        //Chamar a classe Screenchot
        Screenshot.tirarPrint(navegador,"C:\\Users\\felip\\OneDrive\\Documentos\\Prints\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");

        //Aguardar até 10 seg para que a mensagem desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(divDaMensagem));

        //Clicar no link com o texto: "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown(){
        //Fechar o navegador
        //navegador.close();
    }
    /*@Test
    public void LoginVivo(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\felip\\Documents\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);

        navegador.get("https://www.vivo.com.br/para-voce");
        navegador.manage().window().maximize();

        //navegador.findElement(By.linkText("São Paulo - SP")). click();
        navegador.findElement(By.linkText("Login")).click();

        WebElement campoEmailOuCPF = navegador.findElement(By.name("vivo_login_username"));
        campoEmailOuCPF.click();
        campoEmailOuCPF.sendKeys("45829304848");

        WebElement campoSenha = navegador.findElement(By.name("vivo_login_password"));
        campoSenha.click();
        campoSenha.sendKeys("170897");

        navegador.findElement(By.className("btn-purple")).click();

        assertEquals(1,1);
    }*/
}
