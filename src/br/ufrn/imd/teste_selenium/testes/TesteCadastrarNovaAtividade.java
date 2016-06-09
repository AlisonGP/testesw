package br.ufrn.imd.teste_selenium.testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastrarNovaAtividade {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
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
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-close")).click();
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
