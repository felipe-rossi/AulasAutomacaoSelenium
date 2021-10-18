package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

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
        navegador.get("https://www.facebook.com");
    }

    @Test
    public void testAdcionarUmaInformacaoAdicionalDoUsuario(){
        //Clicar no campo e-mail
        WebElement campoEmail = navegador.findElement(By.id("email"));
        campoEmail.click();

        //Digitar no campo o email felipe.rossigz@hotmail.com
        campoEmail.sendKeys("felipe.rossigz@hotmail.com");

        //Clicar no campo senha
        WebElement campoSenha = navegador.findElement(By.id("pass"));
        campoSenha.click();

        //Digitar a senha
        campoSenha.sendKeys("BsCOgLCQdf");

        //Clicar no botão sign in
        navegador.findElement(By.name("login")).click();

        //Validar o nome "Felipe" após o login
        WebElement AreaNome = navegador.findElement(By.linkText("Felipe Rossi"));
        String nomedoUsuario = AreaNome.getText();

        // Verificar se o teste foi positivo ou negativo
        assertEquals("Felipe Rossi",nomedoUsuario);
    }

    @After
    public void tearDown(){
        //Fechar o navegador
        navegador.close();
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
