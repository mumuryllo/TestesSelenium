package Se??o1_Selenium_Web_Driver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	//Nome dessa t?cnica testes orientados a dados
	private WebDriver driver;
	private DSL dsl;	
	private CampoTreinamentoPage page;
	
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String [] esportes;
	@Parameter(value=5)
	public String msg;

		@Before
		// Junit antes de cada metodo execute o que est? aqui
		public void incializar() {
			  driver = new FirefoxDriver();
			  driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			  dsl  =new DSL(driver);
			  page =new CampoTreinamentoPage(driver);
		}
		
		@After
		// Junit depois de cada metodo execute o que est? aqui
		// Mesmo que o m?todo falhe o After contnuar? executando o que voce propos a fazer
		public void finalizar() {
			   driver.quit(); 
		}
		
		@Parameters
		public static Collection<Object[]> getCollection(){
			return Arrays.asList(new Object[][] {
				{"","","",Arrays.asList(),new String[] {},"Nome eh obrigatorio"},
				{"Muryllo","","",Arrays.asList(),new String[] {},"Sobrenome eh obrigatorio"},
				{"Muryllo","Soares","",Arrays.asList(),new String[] {},"Sexo eh obrigatorio"},
				{"Muryllo","Soares","Masculino",Arrays.asList("Carne","Vegetariano"),new String[] {},"Tem certeza que voce eh vegetariano?"},
				{"Muryllo","Soares","Masculino",Arrays.asList("Carne"),new String[] {"Karate","O que eh esporte?"},"Voce faz esporte ou nao?"}
			});
		}
	
	@Test
	public void deveValidarRegras() {
		 page.setNome(nome);
		 page.setsobreNome(sobrenome);
		 if(sexo.equals("Masculino")) {
			 page.setSexoMasculino();
			 }
		 if(sexo.equals("Feminino")) {
			 page.setSexoFeminino();
			 }
		 if (comidas.contains("Carne"))page.setComidaCarne();
		 if (comidas.contains("Vegetariano"))page.setComidaVegetariana();
		 if (comidas.contains("Frango"))page.setComidaFrango();
		 if (comidas.contains("Pizza"))page.setComidaPizza();
		 page.setEsportes(esportes);
	     page.cadastrar();
	     System.out.println(msg);
	     Assert.assertEquals(msg, dsl.AlertaObterTextoAceito());
	}
	
}
