package Seção1_Selenium_Web_Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
private WebDriver driver;
	
	@Before
	// Junit antes de cada metodo execute o que está aqui
	public void incializar() {
		  driver = new FirefoxDriver();
		  driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	// Junit depois de cada metodo execute o que está aqui
	// Mesmo que o método falhe o After contnuará executando o que voce propos a fazer
	public void finalizar() {
		   driver.quit(); 
	}
	
	
	@Test
	public  void teste() {
	 Assert.assertEquals("Google",driver.getTitle());
	 driver.manage().window().setSize(new Dimension(1200, 765));
	 //driver.manage().window().maximize();
	 // fecha todas as abas close fecha uma só
	 
	}

}
