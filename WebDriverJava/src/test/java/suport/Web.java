package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver criarChrome(){
        //Informando o tipo do driver e o caminho
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\felip\\Documents\\Drivers\\chromedriver.exe");

        //Abrindo o navegador chrome
        WebDriver navegador =  new ChromeDriver();

        //Definindo um timeout para evitar futuros erros, definir um tempo de espera para carregar a página e seus elementos
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Deixando em full screen
        navegador.manage().window().maximize();

        // Inserindo a Url que deseja acessar
        navegador.get("http://www.juliodelima.com.br/taskit/");


        return navegador;
    }
}
