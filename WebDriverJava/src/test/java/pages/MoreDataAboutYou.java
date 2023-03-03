package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


public class MoreDataAboutYou extends BasePage {
    public MoreDataAboutYou(WebDriver navegador) {
        super(navegador);
    }

    public String adicionarNovaInformacao(String tipo, String contato){

        //Identificar o formulário para adicionar mais dados
        WebElement formAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Pegando o name do campo de seleção e setando para a opção Phone
        WebElement campoDeSelecao = formAddMoreData.findElement(By.name("type"));
        new Select(campoDeSelecao).selectByValue(tipo);

        //Preenchedo o  campo Contato de name: "contact" com o número:"+551191234-5678"
        formAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //Clicando no link save de texto: "SAVE"
        formAddMoreData.findElement(By.linkText("SAVE")).click();

        //Validar que a mensagem exibida seja: "Your contact has been added!"
        return navegador.findElement(By.id("toast-container")).getText();

    }


}
