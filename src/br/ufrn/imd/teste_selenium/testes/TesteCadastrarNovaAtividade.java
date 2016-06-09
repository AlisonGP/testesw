package br.ufrn.imd.teste_selenium.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastrarNovaAtividade {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://testes.imd.ufrn.br/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCadastrarNovaAtividade() throws Exception {
		driver.get(baseUrl + "/inova/");
		driver.findElement(By.cssSelector("a > div > img")).click();
		driver.findElement(By.name("j_username")).clear();
		driver.findElement(By.name("j_username")).sendKeys("admin");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn-login")).click();
		driver.findElement(By.linkText("Empresas")).click();
		driver.findElement(By.id("listaEmpresas:0:avatar")).click();
		driver.findElement(By.xpath("//form[@id='formulario']/div[3]/div/div[3]/div[5]/p[2]")).click();
		driver.findElement(By.name("j_idt163")).click();
		driver.findElement(By.id("atividade")).clear();
		driver.findElement(By.id("atividade")).sendKeys("asdasdasd");
		driver.findElement(By.id("dataLimite_input")).click();
		driver.findElement(By.xpath("//div[@id='incubadoraIsResponsavel']/div[2]/span")).click();
		new Select(driver.findElement(By.id("tipoAssessoria"))).selectByVisibleText("Capital");
		driver.findElement(By.id("btnCadastrar")).click();
		assertEquals("Operação realizada com sucesso!",
				driver.findElement(By.cssSelector("ui-messages-info-summary")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
