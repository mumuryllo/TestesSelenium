package Se??o1_Selenium_Web_Driver;

import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
	private DSL dsl;	

    public CampoTreinamentoPage(WebDriver driver) {
    	  dsl =new DSL(driver);
    }
	public void setNome(String nome) {
		dsl.escreva("elementosForm:nome", nome);
	}
	public void setsobreNome(String sobrenome) {
		dsl.escreva("elementosForm:sobrenome", sobrenome);
	}
	public void setSexoMasculino() {
		 dsl.clicarRadio("elementosForm:sexo:0");
	}
	public void setSexoFeminino() {
		 dsl.clicarRadio("elementosForm:sexo:1");
	}
	public void setComidaCarne() {
		 dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	public void setComidaVegetariana() {
		 dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	public void setComidaPizza() {
		 dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	public void setComidaFrango() {
		 dsl.clicarRadio("elementosForm:comidaFavorita:1");
	}
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	public void setEsportes(String... valores) {
		for(String valor:valores)
		dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	public void cadastrar() {
		 dsl.ClicarBotao("elementosForm:cadastrar");
	}
	public String obterResultadoCadastro() {
		return dsl.ObterTexto("resultado");
	}
	public String obterNomeCadastro() {
		return dsl.ObterTexto("descNome");
	}
	public String obterSobrenomeCadastro() {
		return dsl.ObterTexto("descSobrenome");
	}
	public String obterComidaCadastro() {
		return dsl.ObterTexto("descComida");
	}
	public String obterEscolaridadeCadastro() {
		return dsl.ObterTexto("descEscolaridade");
	}
	public String obterSexoCadastro() {
		return dsl.ObterTexto("descSexo");
	}
	public String obterEsporteCadastro() {
		return dsl.ObterTexto("descEsportes");
	}
	
}
