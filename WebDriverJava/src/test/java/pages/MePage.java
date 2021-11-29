package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarMoreData(){

        //Clicar no link com o texto: "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddNovoContato clicarNoBotaoAddMoreData(){
        //Clicar no botão atraves do seu Xpath:"//button[@data-target=\"addmoredata""));
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new AddNovoContato(navegador);
    }
}
