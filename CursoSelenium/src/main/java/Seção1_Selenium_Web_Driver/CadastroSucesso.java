package Seção1_Selenium_Web_Driver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroSucesso {
private WebDriver driver;
private CampoTreinamentoPage page;

	@Before
	// Junit antes de cada metodo execute o que está aqui
	public void incializar() {
		  driver = new FirefoxDriver();
		  driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		  page =new CampoTreinamentoPage(driver);
	}
	
	@After
	// Junit depois de cada metodo execute o que está aqui
	// Mesmo que o método falhe o After contnuará executando o que voce propos a fazer
	public void finalizar() {
		   driver.quit(); 
	}
	
	
	
	@Test
	public void testeCadastro() {
		 page.setNome("Muryllo");
		 page.setsobreNome("Soares");
		 page.setSexoMasculino();
		 page.setComidaVegetariana();
		 page.setEscolaridade("Superior");
	     page.setEsportes("Natacao");
	     page.cadastrar();
		 Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		 Assert.assertTrue( page.obterNomeCadastro().endsWith("Muryllo"));
		 Assert.assertEquals("Sobrenome: Soares",page.obterSobrenomeCadastro());
		 Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		 Assert.assertEquals("Comida: Vegetariano", page.obterComidaCadastro());
		 Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		 Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
		}
	
	
	
}
