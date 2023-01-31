package Seção1_Selenium_Web_Driver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	private WebDriver driver;
	
    public DSL(WebDriver driver){
    	this.driver= driver;
    }
    
    //TextField e TextArea
    public void escreva(By by, String texto) {
    	driver.findElement(by).clear();
		 driver.findElement(by).sendKeys(texto); 
	}
    
    public void escreva(String id_campo, String texto) {
		 escreva(By.id(id_campo),texto); 
	}
    
	public String ObterValorCampo (String id_campo){
	  return   driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	
	// Radio e Check
	 public void clicarRadio(String id) {
		 driver.findElement(By.id(id)).click(); 
	   }
	 
	 public boolean radioMarcado(String id) {
	 return	 driver.findElement(By.id(id)).isSelected(); 
	 }
	 
	 public void clicarCheck(String id) {
		 driver.findElement(By.id(id)).click(); 
	   }
	 
	 public boolean CheckMarcado(String id) {
	 return	 driver.findElement(By.id(id)).isSelected(); 
	 }
	 
	 
	 // Combos
	 
	
	 public void selecionarCombo(String id, String valor) {
		 WebElement element = driver.findElement(By.id(id));
	     Select combo = new Select(element);
	     combo.selectByVisibleText(valor);
		}	
	 public void deselecionarCombo(String id, String valor) {
		 WebElement element = driver.findElement(By.id(id));
	     Select combo = new Select(element);
	     combo.deselectByVisibleText(valor);
		}
	     public String ObterValorCombo(String id) {
		 WebElement element = driver.findElement(By.id(id));
	     Select combo = new Select(element);
	     return combo.getFirstSelectedOption().getText();
		}
	     
	     public List<String> obterValoresCombo(String id){
	    	 WebElement element= driver.findElement(By.id("elementosForm:esportes"));
	    	 Select combo = new Select(element);
	    	 List<WebElement> allselectedOptions = combo.getAllSelectedOptions();
	    	 List<String> valores = new ArrayList<String>();
	    	 for(WebElement opcao:allselectedOptions) {
	    		 valores.add(opcao.getText());
	    	 }
	    	 
	    	 return valores;
	     }
	     public int obterQuantidadeOpcoesCombo(String id) {
	    	 WebElement element= driver.findElement(By.id("elementosForm:esportes"));
	    	 Select combo = new Select(element);
	    	 List<WebElement> options =combo.getOptions();
	    	 return options.size();
	     }
	     
	     public boolean VerificarOpcaoCombo(String id,String opcao) {
	    	 WebElement element= driver.findElement(By.id(id));
	    	 Select combo = new Select(element);
	    	 List<WebElement> options =combo.getOptions();
	    	 for(WebElement option:options) {
	    		 if(option.getText().equals(opcao)){
	    			 return true;
	    		 }
	    	 }
	    	 return false;
	     }
	     
	     
	     // Botao 
	     
	     public void ClicarBotao(String id) {
		 driver.findElement(By.id(id)).click();	
        }
	     
	     public String ObterValueElemento(String id){
	   	  return   driver.findElement(By.id(id)).getAttribute("value");
	   	}
	   	
// Link
   public void ClicarLink(String link) {
	 driver.findElement(By.linkText(link)).click();	
   }
	
   
   //Texto
        public String ObterTexto(By by) {
	    return driver.findElement(by).getText();
		}
	    
   
    public String ObterTexto(String id) {
    return ObterTexto(By.id(id));
	}
    
    //Alerts
    public String AlertaObterTexto() {
    	Alert alert= driver.switchTo().alert();
    	return alert.getText();
    }    
    
    public String AlertaObterTextoAceito() {
    	Alert alert= driver.switchTo().alert();
    	String valor=alert.getText();
    	alert.accept();
    	return valor;
    }    
    public String AlertaObterTextoNegado() {
    	Alert alert= driver.switchTo().alert();
    	String valor=alert.getText();
        alert.dismiss();
    	return valor;
    } 
    
    public void alertaEscrever(String valor) {
    	Alert alert= driver.switchTo().alert();
    	alert.sendKeys(valor);
    	alert.accept();
    }
       
    //Frames e Janelas
    public void entrarFrame(String id) {
    	driver.switchTo().frame(id);
    }
     
    public void sairFrame() {
    	driver.switchTo().defaultContent();
    }
    
    public void trocarJanela(String id) {
    	driver.switchTo().window(id);
    }
 
    
}
