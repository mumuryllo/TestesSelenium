package Seção1_Selenium_Web_Driver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCampoTreinamento.class,
	CadastroSucesso.class,
	TesteRegrasCadastro.class
})
public class SuiteTestes {

}
