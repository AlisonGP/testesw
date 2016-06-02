package br.ufrn.imd.teste_selenium.testes;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;

import org.junit.BeforeClass;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSeleniumWebDriver {

	private static WebDriver driver;

	@BeforeClass

	public static void setUpTest() {

		System.setProperty("webdriver.chrome.driver",

				"C:/Program Files (x86)/Google/Chrome/chromedriver.exe");

		// driver = new ChromeDriver();

		driver = new FirefoxDriver();

		driver.get("http://testes.imd.ufrn.br/keys/");

	}

	@AfterClass

	public static void tearDownTest() {

		// driver.quit();

	}

	@Test

	public void testaTituloDaPagina() {

		assertEquals("Tela de boas vindas", driver.getTitle());

	}

	@Test

	public void testaLoginDevMedia() {

		WebElement linkLogin = driver.findElement(By.linkText("Fazer login"));

		linkLogin.click();

		assertEquals("Keys | IMD", driver.getTitle());

		WebElement element = driver.findElement(By.name("j_username"));

		// Insere dados no elemento "usuario".

		element.sendKeys("admin");

		// Atribui ao objeto “element” o elemento de atributo "name" igual a

		// "senha".

		element = driver.findElement(By.name("j_password"));

		// Insere dados no elemento "senha".

		element.sendKeys("admin");

		// Clica no botão "OK" e submete os dados para concluir o login.

		driver.findElement(By.className("btn-login")).click();

	}

}