package Seção1_Selenium_Web_Driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrames {
private WebDriver driver;
private DSL dsl;

	
	@Before
	// Junit antes de cada metodo execute o que está aqui
	public void incializar() {
		  driver = new FirefoxDriver();
		  driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		  dsl =new DSL(driver);
	}
	
	@After
	// Junit depois de cada metodo execute o que está aqui
	// Mesmo que o método falhe o After contnuará executando o que voce propos a fazer
	public void finalizar() {
		   driver.quit(); 
	}
	

	@Test
	public void InteragirFrame() {
	 dsl.entrarFrame("frame1");
	 dsl.ClicarBotao("frameButton");
	 String msg= dsl.AlertaObterTextoAceito();
     Assert.assertEquals("Frame OK!", msg);
     dsl.sairFrame();
     dsl.escreva("elementosForm:nome", msg);
     
     	}
	
	@Test
	public void InteragirJanelas() {
		dsl.ClicarBotao("buttonPopupEasy");
        dsl.trocarJanela("Popup");
        dsl.escreva(("textarea"), "Deu certo?");
        driver.close();
        dsl.trocarJanela("");
        dsl.escreva(("textarea"), "e agora?");
	}
	@Test
	public void InteragirJanelasSemTitulo() {
	 dsl.ClicarBotao("buttonPopupHard");	
	 System.out.println(driver.getWindowHandle());
	 System.out.println(driver.getWindowHandles());
     dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
     dsl.escreva(("textarea"), "Deu certo?");
     dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
     dsl.escreva(("textarea"), "e agora?");
	}
	
	
	
	
}
