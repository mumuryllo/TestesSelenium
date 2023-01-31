package Se��o1_Selenium_Web_Driver;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	// Junit antes de cada metodo execute o que est� aqui
	public void incializar() {
		  driver = new FirefoxDriver();
		  driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		  dsl =new DSL(driver);
	}
	
	@After
	// Junit depois de cada metodo execute o que est� aqui
	// Mesmo que o m�todo falhe o After contnuar� executando o que voce propos a fazer
	public void finalizar() {
		   driver.quit(); 
	}
	
	@Test
	public void textField() {
	dsl.escreva("elementosForm:nome", "Muryllo");
     Assert.assertEquals("Muryllo", dsl.ObterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void textFieldDuplo() {
		 dsl.escreva("elementosForm:nome", "Muryllo");
	     Assert.assertEquals("Muryllo", dsl.ObterValorCampo("elementosForm:nome"));
		 dsl.escreva("elementosForm:nome", "Soares");
		 Assert.assertEquals("Soares", dsl.ObterValorCampo("elementosForm:nome"));
		}
	
	
	
	@Test
	public void InteragirTextArea() {
	 dsl.escreva("elementosForm:sugestoes", "Teste");
     Assert.assertEquals("Teste",  dsl.ObterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void InteragirRadioButton() {
     driver.findElement(By.id("elementosForm:sexo:0")).click();
     Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}
	
	@Test
	public void InteragirCheckBox() {
     dsl.clicarRadio("elementosForm:comidaFavorita:1");
     Assert.assertTrue(dsl.radioMarcado("elementosForm:comidaFavorita:1"));
	}
	
	@Test
	public void InteragirComboBox() {
		 // posso testar pelo index
	     //combo.selectByIndex(1);
	     // ou pelo value
	    // combo.selectByValue("superior");
	     // ou pelo visibletext	
     dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
     Assert.assertEquals("Superior", dsl.ObterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void VerificarValoresCombo() {
    Assert.assertEquals(5,dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
    Assert.assertTrue(dsl.VerificarOpcaoCombo("elementosForm:escolaridade","Superior"));
	}
	
	
	@Test
	public void CombosMultiplos() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        List<String> op�oesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(3, op�oesMarcadas.size());
        dsl.deselecionarCombo("elementosForm:esportes","Corrida");
        op�oesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, op�oesMarcadas.size());
        Assert.assertTrue(op�oesMarcadas.containsAll(Arrays.asList("Natacao","O que eh esporte?")));
	}
	
	@Test
	public void DeveInteragirBotoes() {
	 dsl.ClicarBotao("buttonSimple");
     Assert.assertEquals("Obrigado!", dsl.ObterValueElemento("buttonSimple"));
	}
	
	@Test
	@Ignore
	// ignora esse teste
	public void DeveInteragirLinks() {
		dsl.ClicarLink("Voltar");
	     Assert.assertEquals("Voltou!", dsl.ObterTexto("resultado"));

	}
	
	
	@Test
	public void BuscarTextosPagina() {
	      // Nem sempre � bom fazer testes pela tag pois sempre encontrar� a primeira ocorr�ncia		  
	      // Tente por classe ou id
	      //     Assert.assertTrue
	      // (driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
          driver.manage().window().setSize(new Dimension(1200,765));
          Assert.assertEquals("Campo de Treinamento", dsl.ObterTexto(By.tagName("h3")));
          Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
          dsl.ObterTexto(By.className("facilAchar")));
	}
}
