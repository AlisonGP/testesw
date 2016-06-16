package br.ufrn.imd.teste_selenium.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastroNovaEmpresa {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver(new FirefoxBinary(new File("D:/Mozila/firefox.exe")), new FirefoxProfile());
		baseUrl = "http://testes.imd.ufrn.br/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCadastrarNovaEmpresa() throws Exception {
		driver.manage().window().maximize();
		driver.get(baseUrl + "inova");
		/** Login */
		driver.findElement(By.cssSelector("a > div > img")).click();
		driver.findElement(By.name("j_username")).clear();
		driver.findElement(By.name("j_username")).sendKeys("admin");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn-login")).click();

		/** Nova empresa */
		driver.findElement(By.linkText("Empresas")).click();
		driver.findElement(By.linkText("Nova Empresa")).click();
		
		/** Preencher dados */
		driver.findElement(By.id("razaoSocial")).clear();
		driver.findElement(By.id("razaoSocial")).sendKeys("....");
		driver.findElement(By.id("nomeFantasia")).clear();
		driver.findElement(By.id("nomeFantasia")).sendKeys("....");
		driver.findElement(By.id("areaAtuacao")).clear();
		driver.findElement(By.id("areaAtuacao")).sendKeys("....");
		driver.findElement(By.id("cnpj")).clear();
		driver.findElement(By.id("cnpj")).sendKeys("15.572.585/0001-91");
		driver.findElement(By.id("tipoEmpresa")).click();
	
		driver.findElement(By.id("tipoEmpresa")).click();
		driver.findElement(By.id("tipoEmpresa")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("tipoEmpresa")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("dataConstituicao_input")).clear();
		driver.findElement(By.id("dataConstituicao_input")).sendKeys("02/02/0200");
		driver.findElement(By.id("dataEntrada_input")).clear();
		driver.findElement(By.id("dataEntrada_input")).sendKeys("02/02/9999");

		driver.findElement(By.id("nomeProduto")).click();
		driver.findElement(By.id("nomeProduto")).clear();
		driver.findElement(By.id("nomeProduto")).sendKeys("....");
		driver.findElement(By.id("descricaoProduto")).clear();
		driver.findElement(By.id("descricaoProduto")).sendKeys("....");
		driver.findElement(By.id("linkEmpresa")).clear();
		driver.findElement(By.id("linkEmpresa")).sendKeys("�123321");
		driver.findElement(By.id("descricaoPortal")).clear();
		driver.findElement(By.id("descricaoPortal")).sendKeys("!@#!$$!@#!@#WERWE");

		/** Dados socio */
		driver.findElement(By.name("j_idt86")).click();
		driver.findElement(By.id("cpf")).clear();
		driver.findElement(By.id("cpf")).sendKeys("309.449.617-20");
		driver.findElement(By.id("cpf")).sendKeys(Keys.TAB);
		driver.findElement(By.id("cpf")).click();
		driver.findElement(By.id("cpf")).sendKeys(Keys.TAB);
		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("nome")).sendKeys("asdlkjasd");
		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("nome")).sendKeys("asdlkjasd");
		driver.findElement(By.id("rg")).clear();
		driver.findElement(By.id("rg")).sendKeys("184486385");
		driver.findElement(By.id("dataNascimento_input")).clear();
		driver.findElement(By.id("dataNascimento_input")).sendKeys("01/01/0111");

		driver.findElement(By.cssSelector("div.col-sm-6.col-xs-12")).click();
		new Select(driver.findElement(By.id("estadoCivil"))).selectByVisibleText("solteiro");
		driver.findElement(By.id("profissao")).clear();
		driver.findElement(By.id("profissao")).sendKeys("qualquer uma");
		driver.findElement(By.xpath("//table[@id='sexo']/tbody/tr/td[3]/div/div[2]/span")).click();
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("2@2.com");
		driver.findElement(By.id("email")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("sexo:0")).click();		

		driver.findElement(By.id("j_idt95")).click();
		driver.findElement(By.className("inv-submit btn-salvar-empresa")).click();
		
		assertEquals("Opera��o realizada com sucesso!",
				driver.findElement(By.className("ui-messages-info-summary")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
