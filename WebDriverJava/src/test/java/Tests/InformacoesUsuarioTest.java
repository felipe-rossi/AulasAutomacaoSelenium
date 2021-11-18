package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suport.Generator;
import suport.Screenshot;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        //Pegando o caminho do chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\felip\\Documents\\Drivers\\chromedriver.exe");

        //Abrindo o navegador chrome
        navegador =  new ChromeDriver();

        //Definindo um timeout para evitar futuros erros, definir um tempo de espera para carregar a página e seus elementos
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Deixando em full screen
        navegador.manage().window().maximize();

        // Inserindo a Url que deseja acessar
        navegador.get("http://www.juliodelima.com.br/taskit/");

        //Clicar no link de nome: "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificar o formulário de login
        WebElement formLogin = navegador.findElement(By.id("signinbox"));

        //Inserir o user: "julio0001" no campo de login de name: "login"
        formLogin.findElement(By.name("login")).sendKeys("julio0001");

        //Inserir a senha: "123456" no campo de senha de name: "password"
        formLogin.findElement(By.name("password")).sendKeys("123456");

        //Clicar no botão: "Sign in" do texto: "SIGN IN"
        formLogin.findElement(By.linkText("SIGN IN")).click();

        //Clicar no link que tenha a class: "me"
        navegador.findElement(By.className("me")).click();

        //Clicar no link com o texto: "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

   //@Test
    public void testAdcionarUmaInformacaoAdicionalDoUsuario(){
        //Clicar no botão atraves do seu Xpath:"//button[@data-target=\"addmoredata""));
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o formulário para adicionar mais dados
        WebElement formAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Pegando o name do campo de seleção e setando para a opção Phone
        WebElement campoDeSelecao = formAddMoreData.findElement(By.name("type"));
        new Select(campoDeSelecao).selectByValue("phone");

        //Preenchedo o  campo Contato de name: "contact" com o número:"+551191234-5678"
        formAddMoreData.findElement(By.name("contact")).sendKeys("+551191234-5678");

        //Clicando no link save de texto: "SAVE"
        formAddMoreData.findElement(By.linkText("SAVE")).click();

        //Validar que a mensagem exibida seja: "Your contact has been added!"
        WebElement mensagemPopUp = navegador.findElement(By.id("toast-container"));
        String textoExibido = mensagemPopUp.getText();
        assertEquals("Your contact has been added!", textoExibido);
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
