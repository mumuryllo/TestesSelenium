package Seção1_Selenium_Web_Driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlerts {

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
	public void InteragirAlertSimples() {
	     // o alert tem que fechar e ai sim executamos a função de escrever
		dsl.ClicarBotao("alert");
		String texto = dsl.AlertaObterTextoAceito();
        Assert.assertEquals("Alert Simples", texto);
        dsl.escreva("elementosForm:nome", texto);
	}
	
	@Test
	public void InteragirAlertConfirm() {
		dsl.ClicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.AlertaObterTextoAceito());
        Assert.assertEquals("Confirmado", dsl.AlertaObterTextoAceito());
        dsl.ClicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.AlertaObterTextoNegado());
        Assert.assertEquals("Negado", dsl.AlertaObterTextoNegado());

	}
	
	@Test
	public void InteragirAlertPrompt() {
		dsl.ClicarBotao("prompt");
		Assert.assertEquals("Digite um número", dsl.AlertaObterTexto());
		dsl.alertaEscrever("12");
        Assert.assertEquals("Era 12?", dsl.AlertaObterTextoAceito());
        Assert.assertEquals(":D", dsl.AlertaObterTextoAceito());
	}
	
}
