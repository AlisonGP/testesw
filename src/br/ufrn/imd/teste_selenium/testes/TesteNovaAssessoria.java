package br.ufrn.imd.teste_selenium.testes;

import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class TesteNovaAssessoria {
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
  public void testENovaAssessoria() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "/inova/");
    driver.findElement(By.cssSelector("a > div > img")).click();
    driver.findElement(By.name("j_username")).clear();
    driver.findElement(By.name("j_username")).sendKeys("admin");
    driver.findElement(By.name("j_password")).clear();
    driver.findElement(By.name("j_password")).sendKeys("admin");
    driver.findElement(By.cssSelector("input.btn-login")).click();
    driver.findElement(By.linkText("Empresas")).click();
    
    driver.get(baseUrl + "inova/pages/assessoria/form.jsf");
    
    driver.findElement(By.id("empresaPojo_input")).clear();
    driver.findElement(By.id("empresaPojo_input")).sendKeys("Anolis");
    driver.findElement(By.xpath("//div[@id='empresaPojo_panel']/ul/li")).click();
    driver.findElement(By.id("assessorPojo_input")).clear();
    driver.findElement(By.id("assessorPojo_input")).sendKeys("Julian");

    driver.findElement(By.xpath("//div[@id='assessorPojo_panel']/ul/li")).click();
    driver.findElement(By.xpath("//div[@id='tiposDeAssessoria']/span/label")).click();
    driver.findElement(By.xpath("//div[@id='tiposDeAssessoria_panel']/div[2]/ul/li/label")).click();
    driver.findElement(By.cssSelector("#btnAddTipoAssessoria > img")).click();
    
    
    driver.findElement(By.id("dataReuniao_input")).clear();
    driver.findElement(By.id("dataReuniao_input")).sendKeys("01/01/1111");
    driver.findElement(By.id("horaInicial_input")).click();
    driver.findElement(By.id("horaInicial_input")).clear();
    driver.findElement(By.id("horaInicial_input")).sendKeys("10:00");
    driver.findElement(By.id("horaFinal_input")).click();
    driver.findElement(By.id("horaFinal_input")).clear();
    driver.findElement(By.id("horaFinal_input")).sendKeys("05:00");
    driver.findElement(By.id("descricaoAssessoria")).clear();
    driver.findElement(By.id("descricaoAssessoria")).sendKeys("asd");
    driver.findElement(By.id("descricaoAssessoria")).sendKeys(Keys.ENTER);
    assertEquals("Operação realizada com sucesso!",
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