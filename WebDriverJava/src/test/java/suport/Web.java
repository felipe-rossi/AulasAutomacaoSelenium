package suport;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "feliperossi_qxFdCI";
    public static final String AUTOMATE_KEY = "HCykDicZC7mi6KeRCB6X";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver criarChrome(){
        //Informando o tipo do driver e o caminho
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\felip\\Documents\\chromedriver.exe");

        //Abrindo o navegador chrome
        WebDriver navegador =  new ChromeDriver();

        //Definindo um timeout para evitar futuros erros, definir um tempo de espera para carregar a página e seus elementos
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Deixando em full screen
        navegador.manage().window().maximize();

        // Inserindo a Url que deseja acessar
        navegador.get("http://www.juliodelima.com.br/taskit/");

        return navegador;
    }

    public static WebDriver criarNavegadorNaNuvem(){
        // Add these capabilities to your test script
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "11");
        caps.setCapability("browserstack.debug", "true");

        WebDriver navegador = null;

        try{
            navegador = new RemoteWebDriver(new URL(URL), caps);

            //Definindo um timeout para evitar futuros erros, definir um tempo de espera para carregar a página e seus elementos
            navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Deixando em full screen
            navegador.manage().window().maximize();

            // Inserindo a Url que deseja acessar
            navegador.get("http://www.juliodelima.com.br/taskit/");

        }catch (Exception e){
            System.out.println("Houve um erro na URL: " + e.getMessage());
        }

        return navegador;

    }
}
